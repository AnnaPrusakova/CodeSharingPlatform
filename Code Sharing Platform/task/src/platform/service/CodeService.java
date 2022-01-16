package platform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.exception.CodeNotFoundException;
import platform.model.Code;
import platform.repository.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeService {

    @Autowired
    private CodeRepository codeRepository;

     public Code saveCode(Code codeSnippet) {
        Code newCode = new Code();
        newCode.setCode(codeSnippet.getCode());
        newCode.setTitle("Code");
        newCode.setDate(LocalDateTime.now());
        newCode.setTime(codeSnippet.getTime());
        newCode.setViews(codeSnippet.getViews());
        newCode.setViewsLimit(codeSnippet.getViews() > 0);
        newCode.setTimeLimit(codeSnippet.getTime() > 0);
        newCode.setStartSeconds(System.currentTimeMillis());
        codeRepository.save(newCode);
        return newCode;
    }

    public Code getCodeById(String id) {
        Code code = codeRepository.findById(id).orElseThrow(CodeNotFoundException::new);
        if (code.isViewsLimit()) {
            int views = code.getViews();
            if (views > 0) {
                code.setViews(views - 1);
                codeRepository.save(code);
            } else {
                codeRepository.delete(code);
                return code;
            }
        }
        if (code.isTimeLimit()) {
            Duration duration = (Duration.between(code.getDate(), LocalDateTime.now()));
            int timeLeft = (code.getTime() - (int) duration.getSeconds());
            if (timeLeft > 0) {
                code.setTime(timeLeft);
            } else {
                codeRepository.delete(code);
                throw new CodeNotFoundException();
            }
        }
        return code;
    }


    public List<Code> getLatestCode() {
        ArrayList<Code> tempList = (ArrayList<Code>) codeRepository.findAll();
        Collections.reverse(tempList);
        return tempList.stream().limit(10).collect(Collectors.toList());
    }

}

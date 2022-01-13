package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeService {

    public final List<Code> codeList = new ArrayList<>();
    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public int getSize() {
        return codeList.size();
    }
     public void saveCode(Code codeSnippet) {
        codeSnippet.setDate(getCurrentDate());
        codeList.add(codeSnippet);
    }

    private String getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return localDateTime.format(formatter);
    }

    public Code getCodeById(int id) {
         return codeList.get(id - 1);
    }

    public List<Code> getLatestCode() {
        ArrayList<Code> tempList = new ArrayList<>(codeList);
        Collections.reverse(tempList);
        return tempList.stream().limit(10).collect(Collectors.toList());

    }
}

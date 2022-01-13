package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JsonController {

    private CodeService codeService;

    public JsonController() {
    }

    @Autowired
    public JsonController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(path = "/api/code/{id}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Code> getJsonById(@PathVariable("id") int id) {
        Code code = codeService.getCodeById(id);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @PostMapping(path = "/api/code/new", produces = "application/json;charset=UTF-8")
    public String newJsonCode(@RequestBody Code code) {
        codeService.saveCode(code);
        return "{ \"id\": \"" + codeService.getSize() + "\" }";
    }

    @GetMapping(path = "/api/code/latest", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Code>> getLatestJsonCode() {
        List<Code> list = codeService.getLatestCode();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

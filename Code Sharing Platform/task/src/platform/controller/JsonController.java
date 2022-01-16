package platform.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.service.CodeService;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class JsonController {

    @Autowired
    private CodeService codeService;

    @GetMapping(path = "/api/code/{id}", produces = "application/json;charset=UTF-8")
    public Code getJsonById(@PathVariable("id") String id) {
        return codeService.getCodeById(id);
    }

    @PostMapping(path = "/api/code/new", produces = "application/json;charset=UTF-8")
    public String newJsonCode(@RequestBody Code code) {
        Code response = codeService.saveCode(code);
        return "{ \"id\": \"" + response.getId() + "\" }";
    }

    @GetMapping(path = "/api/code/latest", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Code>> getLatestJsonCode() {
        List<Code> list = codeService.getLatestCode();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}

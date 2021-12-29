package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller {

   private final CodeService codeService = new CodeService();

    @GetMapping(path = "/code", produces = "text/html")
    public ResponseEntity<String> getHtmlCode() {
        return ResponseEntity.ok().body(codeService.getHtmlCode());
    }

    @GetMapping(path = "/api/code", produces = "application/json;charset=UTF-8")
    public Code getJsonCode() {
        return codeService.getJsonCode();
    }

    @PostMapping(path = "/api/code/new", produces = "application/json;charset=UTF-8")
    public String newJsonCode(@RequestBody Code code) {
        return codeService.newJsonCode(code);
    }

    @GetMapping(path = "/code/new", produces = "text/html")
    public ResponseEntity<String> newHtmlCode() {
        return ResponseEntity.ok().body(codeService.newHtmlCode());
    }
}

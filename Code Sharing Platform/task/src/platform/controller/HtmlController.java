package platform.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.service.CodeService;

import java.util.List;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class HtmlController {

    @Autowired
    private CodeService codeService;

    @GetMapping(path = "/code/{id}", produces = "text/html")
    public String getHtmlById(@PathVariable("id") String id, Model model) {
        Code code = codeService.getCodeById(id);
        model.addAttribute("code", code);
        return "code";
    }

    @GetMapping(path = "/code/new", produces = "text/html")
    public String newHtmlCode() {
        return "newcode";
    }

    @GetMapping(path = "/code/latest", produces = "text/html")
    public String getLatestHtmlCode(Model model) {
        List<Code> result = codeService.getLatestCode();
        model.addAttribute("lastCodes", result);
        return "lastcode";
    }

}

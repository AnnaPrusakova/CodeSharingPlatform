package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HtmlController {

    private CodeService codeService;

    public HtmlController() {
    }

    @Autowired
    public HtmlController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(path = "/code/{id}", produces = "text/html")
    public String getHtmlById(@PathVariable("id") int id, Model model) {
        Code code = codeService.getCodeById(id);
        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.getDate());
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

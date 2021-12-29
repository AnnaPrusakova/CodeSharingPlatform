package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CodeService {

    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private final String title = "Code";
    private final String codeInf = "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}";
    private final Code code = new Code(title, codeInf, getCurrentDate());

    public Code getJsonCode() {
        return code;
    }

    public String getHtmlCode() {

        return "<title>" + code.getTitle() + "</title>" +
                "<body>" +
                "<span id=\"load_date\">" + code.getDate() + "</span>" +
                "<pre id=\"code_snippet\">" + code.getCode() + "</pre>" +
                "</body>";
    }


    public String newJsonCode(Code codeSnippet) {
        code.setCode(codeSnippet.getCode());
        return "{}";
    }

    public String newHtmlCode() {
        String script = "<script type=\"text/javascript\">\n" +
                "function send() {\n" +
                "    let object = {\n" +
                "        \"code\": document.getElementById(\"code_snippet\").value\n" +
                "    };\n" +
                "    \n" +
                "    let json = JSON.stringify(object);\n" +
                "    \n" +
                "    let xhr = new XMLHttpRequest();\n" +
                "    xhr.open(\"POST\", '/api/code/new', false)\n" +
                "    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "    xhr.send(json);\n" +
                "    \n" +
                "    if (xhr.status == 200) {\n" +
                "      alert(\"Success!\");\n" +
                "    }\n" +
                "}" +
                "</script>";
        return "<title>Create</title>" +
                "<body>" +
                "<textarea id=\"code_snippet\"> ... </textarea>" +
                "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" +
                script +
                "</body>";
    }

    private String getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return localDateTime.format(formatter);
    }
}

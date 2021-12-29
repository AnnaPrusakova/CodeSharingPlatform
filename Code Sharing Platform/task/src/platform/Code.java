package platform;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Code {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String title;

    private String code;

    private String date;

    public Code() {

    }

    public Code(String title, String code, String date) {
        this.title = title;
        this.code = code;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

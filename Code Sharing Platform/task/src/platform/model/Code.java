package platform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Code {

    @Id
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id = UUID.randomUUID().toString();

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String title;

    @Column
    private String code;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime date;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String formattedDate;

    @Column
    private int time;

    @Column
    private int views;

    @JsonIgnore
    private boolean timeLimit;

    @JsonIgnore
    private boolean viewsLimit;

    @JsonIgnore
    long startSeconds;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime  getDate() {
        return date;
    }

    public void setDate(LocalDateTime  date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(boolean timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isViewsLimit() {
        return viewsLimit;
    }

    public void setViewsLimit(boolean viewsLimit) {
        this.viewsLimit = viewsLimit;
    }

    public long getStartSeconds() {
        return startSeconds;
    }

    public void setStartSeconds(long startSeconds) {
        this.startSeconds = startSeconds;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}

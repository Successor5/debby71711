package Diary;

import java.time.LocalDateTime;

public class Entry {
    public String setBody;
    private String title;
    private String body;
    private LocalDateTime date;
    private int id;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entry(String title, String body) {
        this.title = title;
        this.body=body;



    }
}
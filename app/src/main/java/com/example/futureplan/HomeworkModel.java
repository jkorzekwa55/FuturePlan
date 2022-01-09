package com.example.futureplan;

public class HomeworkModel {
    public int id;
    public String subject;
    public String date;
    public String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HomeworkModel(int id, String subject, String date, String title) {

        this.id = id;
        this.subject = subject;
        this.date = date;
        this.title = title;
    }
}

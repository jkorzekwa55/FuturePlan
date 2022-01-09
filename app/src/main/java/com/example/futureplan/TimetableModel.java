package com.example.futureplan;

public class TimetableModel {
    public int id;
    public String dayOfWeek;
    public String subject;
    public String time;
    public String classroom;


    public TimetableModel(int id, String dayOfWeek, String subject, String time, String classroom) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.subject = subject;
        this.time = time;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}

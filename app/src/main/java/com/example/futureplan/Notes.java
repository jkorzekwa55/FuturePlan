package com.example.futureplan;

public class Notes {
    String Title;
    String Note;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "title='" + Title + '\'' +
                ", note='" + Note + '\'' +
                '}';
    }
}

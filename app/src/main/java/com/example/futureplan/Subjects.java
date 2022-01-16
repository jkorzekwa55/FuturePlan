package com.example.futureplan;

import java.util.List;

public class Subjects {
    String name;
    List<String> paragraphs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "name='" + name + '\'' +
                ", paragraphs=" + paragraphs +
                '}';
    }
}

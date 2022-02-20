package com.example.futureplan;

import java.util.List;

public class Subjects {
    String name;
    List<TekstPomoceNaukowe> paragraphs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TekstPomoceNaukowe> getParagraphs() {
        return paragraphs;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "name='" + name + '\'' +
                ", paragraphs=" + paragraphs +
                '}';
    }
}

package com.guryasha.demo.entity;

public class TaskEntity {
    public int id;
    public String description;
    public String title;

    public TaskEntity(String title, String description) {
        this.description = description;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    @Override
    public String toString() {
        String task = "<" + Integer.toString(id) + " " + title + " " + description + ">";
        return task;
    }
     */
}
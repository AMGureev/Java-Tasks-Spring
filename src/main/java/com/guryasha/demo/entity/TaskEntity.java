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
    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getTitle() == null) ? 0 : this.getTitle().hashCode());
        result = prime * result + id;
        result = prime * result + ((this.getDescription() == null) ? 0 : this.getDescription().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        TaskEntity task = (TaskEntity) obj;
        return this.title.equals(task.getTitle()) && this.description.equals(task.getDescription()) && id == task.getId();
    }
}
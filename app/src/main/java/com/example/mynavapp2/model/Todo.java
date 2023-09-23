package com.example.mynavapp2.model;

public class Todo {

    private long id;
    private String title;
    private boolean isCompleted;

    public Todo (String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return  isCompleted; }

    public void setCompleted(boolean completed) { isCompleted = completed; }
}

package com.example.demo;

enum Status {
    TODO, INPROGRESS, DONE
}

public class Task {
    private int id;
    private String description;
    private Status status;


    public Task(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }


    public Task() {

    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
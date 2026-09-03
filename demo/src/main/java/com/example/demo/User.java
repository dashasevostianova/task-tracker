package com.example.demo;
import static org.mockito.Mockito.description;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int id = 0;
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public void add (String description) {
        tasks.add(new Task(id, description, Status.TODO));
        id++;
    }

    private int findTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
        //throw mistake!
    }

    public void update(int id, String description) {
        int i = findTask(id);
        if (i != -1) {
            Task t = tasks.get(i);
            t.setDescription(description);
        }
        else {
            System.out.println("This id is invalid");
        }
    }

    public void delete(int id) {
        int i = findTask(id);
        if (i != -1) {
            tasks.remove(i);
        }
        else {
            System.out.println("This id is invalid");
        }
    }

    public void markInProgress(int id) {
        int i = findTask(id);
        if (i != -1) {
            Task t = tasks.get(i);
            t.setStatus(Status.INPROGRESS);;
        }
        else {
            System.out.println("This id is invalid");
        }
    }

    public void markDone(int id) {
        int i = findTask(id);
        if (i != -1) {
            Task t = tasks.get(i);
            t.setStatus(Status.DONE);;
        }
        else {
            System.out.println("This id is invalid");
        }
    }

    public List<Task> listDone(){
        List<Task> done = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.DONE) {
                done.add(t);
            }
        }
        return done;
    }

    public List<Task> listToDo(){
        List<Task> toDo = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.TODO) {
                toDo.add(t);
            }
        }
        return toDo;
    }

    public List<Task> listInProgress(){
        List<Task> inProgress = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.INPROGRESS) {
                inProgress.add(t);
            }
        }
        return inProgress;
    }
}
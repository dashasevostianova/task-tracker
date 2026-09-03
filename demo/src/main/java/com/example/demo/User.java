package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private List<Task> tasks = new ArrayList<>();

    public User() {
        id = 0;
    }

    public int add (String description) {
        tasks.add(new Task(id, description, Status.TODO));
        id++;
        return id-1;
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

    public List<Task> list() {
        System.out.println("The list of all tasks:");
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
             System.out.println("    Tsk ID: " + i +
                    ", description: " + t.getDescription() + " , status: " +
                    t.getStatus());
        }
        return tasks;
    }
    public List<Task> listDone(){
        System.out.println("The list of completed tasks:");
        List<Task> done = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.DONE) {
                System.out.println("    Tsk ID: " + i +
                    ", description: " + t.getDescription());
                done.add(t);
            }
        }
        return done;
    }

    public List<Task> listToDo(){
        System.out.println("The list of tasks to do:");
        List<Task> toDo = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.TODO) {
                System.out.println("    Tsk ID: " + i +
                    ", description: " + t.getDescription());
                toDo.add(t);
            }
        }
        return toDo;
    }

    public List<Task> listInProgress(){
        System.out.println("The list of tasks in progress:");
        List<Task> inProgress = new ArrayList<>();
        Task t;
        for (int i = 0; i < tasks.size(); i++) {
            t = tasks.get(i);
            if (t.getStatus() == Status.INPROGRESS) {
                System.out.println("    Tsk ID: " + i +
                    ", description: " + t.getDescription());
                inProgress.add(t);
            }
        }
        return inProgress;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
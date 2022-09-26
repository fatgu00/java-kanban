package com.company;

public class Task {
    int id;
    String name;
    String description;
    TaskStatus status;


    Task(String name, TaskStatus status){
        this.name = name;
        this.status = status;

    }

    public Task(String name, String description, TaskStatus status, int taskId) {
        this.id = taskId;
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public Task(String name, String description, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

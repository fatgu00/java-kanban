package com.company;


import java.util.ArrayList;


public class Epic extends Task {

    int id;

    Epic(String name, TaskStatus status,int epicId) {
        super(name,status);
        id = epicId;

    }


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

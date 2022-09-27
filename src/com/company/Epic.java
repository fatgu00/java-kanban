package com.company;

import java.util.ArrayList;

public class Epic extends Task {

    ArrayList<Integer> epicId = new ArrayList<>();

    Epic(String name, TaskStatus status) {
        super(name,status);

    }


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", epicId=" + epicId +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

package com.company;

import java.util.ArrayList;


public class Subtask extends Task {
    int id;
    int subIdHash;
    Subtask(String name, String description, TaskStatus status, int epicId, int subId) {
        super(name, description, status);
        id = epicId;
        subIdHash = subId;
    }


    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {

    List<Integer> subId = new ArrayList<>();

    Epic(String name, TaskStatus status) {
        super(name,status);
    }


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", subId=" + subId +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}

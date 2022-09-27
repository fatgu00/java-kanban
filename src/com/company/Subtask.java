package com.company;


import java.util.ArrayList;

public class Subtask extends Task {

    private ArrayList<Integer> epicId;

    Subtask(String name, String description, TaskStatus status, ArrayList<Integer> epicId) {
        super(name, description, status);
        this.epicId = epicId;
    }

    public ArrayList<Integer> getEpicId() {
        return epicId;
    }
//Преопределение equals и hashcode не нужно потому что тут нет индивидального поля класса. они все получают наследство от родддительского класса
    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", epicId=" + epicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

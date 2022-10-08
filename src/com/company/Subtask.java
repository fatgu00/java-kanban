package com.company;

public class Subtask extends Task {

    private Integer epicId;
    Subtask(String name, String description, TaskStatus status) {
        super(name, description, status);
    }

    public void setEpicId(Integer epicId) {
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }


    //Преопределение equals и hashcode не нужно потому что тут нет индивидального поля класса. они все получают наследство от родддительского класса
    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", epicId=" + getEpicId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

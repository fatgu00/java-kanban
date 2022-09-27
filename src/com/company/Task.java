package com.company;

import java.util.Objects;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected TaskStatus status;


    Task(String name, TaskStatus status){
        this.name = name;
        this.status = status;

    }

    public Task(String name, String description, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
    // Преопределение equals необходимо для сравнение оддинаковых id
    // Преопределение hashCode необходимо для того что бы у каждого объекта был индивиддуальное хэш-код
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Task task = (Task) o;
       return id == task.id;
   }

   @Override
   public int hashCode() {
       return Objects.hash(id);
   }

}

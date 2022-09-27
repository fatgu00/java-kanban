package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        Task task1 = new Task("забрать зачеткку","сходить в уник",TaskStatus.DONE);
        Task task2 = new Task("закинуть деньги на карту","сходить в банкомат",TaskStatus.IN_PROGRESS);
        Epic epic1 = new Epic("переезда",TaskStatus.NEW);
        Subtask subtask1 = new Subtask("собрать коробку","собратьвещщи", TaskStatus.NEW, epic1.epicId);
        Subtask subtask2 = new Subtask("сказать прощай","собратьвещщи", TaskStatus.DONE, epic1.epicId);
        Epic epic2 = new Epic("Помыть посуду2",TaskStatus.NEW);
        Subtask subtask3 = new Subtask("купить губку","сходить в магазин",TaskStatus.IN_PROGRESS, epic2.epicId);
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addEpic(epic1);
        manager.addEpic(epic2);
        manager.addSubtask(subtask1);
        manager.addSubtask(subtask2);
        manager.addSubtask(subtask3);
        System.out.println(task1.toString());
        System.out.println(task2.toString());
        System.out.println(epic1.toString());
        System.out.println(epic2.toString());
        System.out.println(subtask1.toString());
        System.out.println(subtask2.toString());
        System.out.println(subtask3.toString());
        System.out.println("       ");

        manager.updateSubtask(subtask3);// проверка на обновление
        System.out.println(epic2);

        manager.deleteEpicById(epic1.id);//Удаление епика
        manager.deleteTaskById(task1.id);//Удаление таска



    }
}

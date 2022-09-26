package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        Task task1 = new Task("забрать зачеткку","сходить в уник",TaskStatus.DONE, manager.taskId());
        Task task2 = new Task("закинуть деньги на карту","сходить в банкомат",TaskStatus.IN_PROGRESS, manager.taskId());
        Epic epic1 = new Epic("переезда",TaskStatus.NEW,manager.epicId());
        Subtask subtask1 = new Subtask("собрать коробку","собратьвещщи", TaskStatus.NEW, epic1.id, manager.subId());
        Subtask subtask2 = new Subtask("сказать прощай","собратьвещщи", TaskStatus.DONE, epic1.id, manager.subId());
        Epic epic2 = new Epic("Помыть посуду2",TaskStatus.NEW ,manager.epicId());
        Subtask subtask3 = new Subtask("купить губку","сходить в магазин",TaskStatus.IN_PROGRESS, epic2.id, manager.subId());
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createEpic(epic1);
        manager.createEpic(epic2);
        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
        manager.createSubtask(subtask3);
        System.out.println(task1.toString());
        System.out.println(task2.toString());
        System.out.println(epic1.toString());
        System.out.println(epic2.toString());
        System.out.println(subtask1.toString());
        System.out.println(subtask2.toString());
        System.out.println(subtask3.toString());
        System.out.println("       ");

        manager.updateSubtask(subtask3,subtask3.id);// проверка на обновление
        System.out.println(epic2);

        manager.deleteEpicByIdentifier(epic1.id);//Удаление епика
        manager.deleteTaskByIdentifier(task1.id);//Удаление таска
        System.out.println(manager.epicHashMap);
        System.out.println(manager.taskHashMap);

    }
}

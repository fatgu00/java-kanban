package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();

        Task task1 = new Task("забрать зачеткку","сходить в уник",TaskStatus.DONE);
        Task task2 = new Task("закинуть деньги на карту","сходить в банкомат",TaskStatus.IN_PROGRESS);
        Epic epic1 = new Epic("переезда",TaskStatus.NEW);
        Subtask subtask1 = new Subtask("собрать коробку","собратьвещщи", TaskStatus.NEW);
        Subtask subtask2 = new Subtask("сказать прощай","собратьвещщи", TaskStatus.DONE);
        Epic epic2 = new Epic("Помыть посуду2",TaskStatus.NEW);
        Subtask subtask3 = new Subtask("купить губку","сходить в магазин",TaskStatus.IN_PROGRESS);
        taskManager.addTask(task1);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addEpic(epic1);
        taskManager.addEpic(epic2);
        taskManager.addSubtask(subtask1, epic1.id);
        taskManager.addSubtask(subtask2, epic1.id);
        taskManager.addSubtask(subtask3, epic2.id);
        System.out.println(task1.toString());
        System.out.println(task2.toString());
        System.out.println(epic1.toString());
        System.out.println(epic2.toString());
        System.out.println(subtask1.toString());
        System.out.println(subtask2.toString());
        System.out.println(subtask3.toString());
        System.out.println("       ");

        //manager.updateSubtask(subtask3);// проверка на обновление
        //System.out.println(epic2);

        //manager.deleteEpicById(epic1.id);//Удаление епика
        //manager.deleteTaskById(task1.id);//Удаление таска
        System.out.println("       ");
        // проверка работы истории
        taskManager.getTaskById(1);
        taskManager.getEpicById(3);
        taskManager.getSubtaskById(5);
        taskManager.getTaskById(2);
        taskManager.getTaskById(1);
        taskManager.getTaskById(1);
        taskManager.getTaskById(1);
        taskManager.getTaskById(1);
        taskManager.getTaskById(1);
        taskManager.getTaskById(2);
        taskManager.getSubtaskById(5);
        taskManager.getTaskById(1);


        System.out.println("       ");
        System.out.println(taskManager.getManagers().getHistory());



    }
}

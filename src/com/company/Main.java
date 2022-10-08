package com.company;

public class Main {

    public static void main(String[] args) {

        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();

        Task task1 = new Task("забрать зачеткку","сходить в уник",TaskStatus.DONE);
        Task task2 = new Task("закинуть деньги на карту","сходить в банкомат",TaskStatus.IN_PROGRESS);
        Epic epic1 = new Epic("переезда",TaskStatus.NEW);
        Subtask subtask1 = new Subtask("собрать коробку","собратьвещщи", TaskStatus.NEW);
        Subtask subtask2 = new Subtask("сказать прощай","собратьвещщи", TaskStatus.DONE);
        Epic epic2 = new Epic("Помыть посуду2",TaskStatus.NEW);
        Subtask subtask3 = new Subtask("купить губку","сходить в магазин",TaskStatus.IN_PROGRESS);
        inMemoryTaskManager.addTask(task1);
        inMemoryTaskManager.addTask(task1);
        inMemoryTaskManager.addTask(task2);
        inMemoryTaskManager.addEpic(epic1);
        inMemoryTaskManager.addEpic(epic2);
        inMemoryTaskManager.addSubtask(subtask1, epic1.id);
        inMemoryTaskManager.addSubtask(subtask2, epic1.id);
        inMemoryTaskManager.addSubtask(subtask3, epic2.id);
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
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getEpicById(3);
        inMemoryTaskManager.getSubtaskById(5);
        inMemoryTaskManager.getTaskById(2);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(2);
        inMemoryTaskManager.getSubtaskById(5);
        inMemoryTaskManager.getTaskById(1);


        System.out.println("       ");
        System.out.println(inMemoryTaskManager.managers.getHistory());



    }
}

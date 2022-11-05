package com.company;

import java.util.List;


public interface TaskManager {

    void addTask(Task task);

    void addSubtask(Subtask subtask, int epicId);

    void addEpic(Epic epic);

    //-------------------Получение списка всех задач.-------------------------------------------------------------------
    List<Task> getTasks();

    List<Subtask> getSubtasks();

    List<Epic> getEpics();


    //-------------------Удаление всех задач----------------------------------------------------------------------------

    void deleteTask();

    void deleteSubtask();

    void deleteEpic();

    //-------------------Получение по идентификатору--------------------------------------------------------------------
    Task getTaskById(int id);

    Epic getEpicById(int id);

    Subtask getSubtaskById(int id);

    //-------------------Удаление по идентификатору.--------------------------------------------------------------------
    void deleteTaskById(int id);

    void deleteEpicById(int id);

    void deleteSubtaskById(int id);

    //-------------------Обновление-------------------------------------------------------------------------------------
    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    List<Subtask> getSubtaskEpics(int id);

    HistoryManager getManagers();


}


package com.company;


import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();

    int id = 1;


//-------------------Создание,запись.-----------------------------------------------------------------------

    void addTask(Task task) {
        tasks.put(id, task);
        task.id = id++;
    }

    void addSubtask(Subtask subtask){
        subtasks.put(id,subtask);
        subtask.id = id++;
    }

    void addEpic (Epic epic){
        epic.epicId.add(id);
        epics.put(id,epic);
        epic.id = id++;


    }

//-------------------Получение списка всех задач.-----------------------------------------------------------------------

    void getTask() {
        for (Integer key : tasks.keySet()){
            Task task = tasks.get(key);
                System.out.println(task);
        }
    }

    void getSubtask() {
        for (Integer key : subtasks.keySet()){
            Subtask subtask = subtasks.get(key);
            System.out.println(subtask);
        }
    }

    void getEpic() {
        for (Integer key:epics.keySet()){
            Epic epic = epics.get(key);
            System.out.println(epic);
        }
    }

//-------------------Удаление всех задач--------------------------------------------------------------------------------

    void deleteTask(){
        tasks.clear();
    }

    void deleteSubtask(){
        subtasks.clear();
    }

    void deleteEpic(){
        deleteSubtask();
        epics.clear();
    }

//-------------------Получение по идентификатору------------------------------------------------------------------------

    void getTaskById(int number){
        Task task = tasks.get(number);
        System.out.println(task);
    }

    void getEpicById(int number){
        Epic epic = epics.get(number);
        System.out.println(epic);
    }

    void getSubtaskById(int number){
        Subtask subtask = subtasks.get(number);
        System.out.println(subtask);
    }

//-------------------Удаление по идентификатору.------------------------------------------------------------------------

    void deleteTaskById(int number){
        tasks.remove(number);
    }

    void deleteEpicById(int number){
        ArrayList<Integer> idHash = new ArrayList<>();
        for (Integer keySubtask : subtasks.keySet()){
            Subtask value = subtasks.get(keySubtask);
            for (Integer kyeArray : value.getEpicId()){
                if (kyeArray == number) {
                    idHash.add(value.id);
                }
            }

        }
        for (int i = 0; i < idHash.size(); i++){
            deleteSubtaskById(idHash.get(i));
        }
        epics.remove(number);
    }

    void deleteSubtaskById(int number){
        subtasks.remove(number);
    }

//-------------------Обновление-----------------------------------------------------------------------------------------

    void updateTask(Task task){
        tasks.remove(task.id);
        tasks.put(task.getId(), task);
    }

    void updateEpic(Epic epic){
        ArrayList<Subtask> subtasks = new ArrayList<>();
        ArrayList<Subtask> subtasksDone = new ArrayList<>();
        ArrayList<Subtask> subtasksNew = new ArrayList<>();
        epics.remove(epic.id);
        epics.put(epic.getId(),epic);
        for (Integer kye : Manager.this.subtasks.keySet()){
            Subtask subtask = Manager.this.subtasks.get(kye);
            if (subtask.getEpicId() == epic.epicId){
                subtasks.add(subtask);
            }
        }
        for (Subtask value : subtasks){
            if (value.status == TaskStatus.NEW ){
                subtasksNew.add(value);
            }
            else if (value.status == TaskStatus.DONE){
                subtasksDone.add(value);
            }
        }
        if (subtasksDone.size() == subtasks.size() & subtasksDone.size() != 0){
            epic.status = TaskStatus.DONE;
        }
        else if(subtasksNew.size() == subtasks.size() & subtasks.size() == 0){
            epic.status = TaskStatus.NEW;
        }
        else {
            epic.status = TaskStatus.IN_PROGRESS;
        }

    }

    void updateSubtask(Subtask subtask){

        subtasks.remove(subtask.id);
        subtasks.put(subtask.getId(),subtask);

    }

    void getSubtaskEpics(int number){
            System.out.println(epics.get(number));
            for (Integer keySubtask : subtasks.keySet()){
                Subtask value = subtasks.get(keySubtask);
                for (Integer kyeArray : value.getEpicId()){
                    if(kyeArray == number){
                        System.out.println(subtasks.get(value.getId()));
                    }
                }
            }
    }


}


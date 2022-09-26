package com.company;


import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    HashMap<Integer, Task> taskHashMap = new HashMap<>();
    HashMap<Integer, Epic> epicHashMap = new HashMap<>();
    HashMap<Integer, Subtask> subtaskHashMap = new HashMap<>();

    private int epicId = 0;
    private int subId = 0;
    private int taskId = 0;

    Integer taskId(){
        taskId += 1;
        return taskId;
    }

    Integer epicId() {
        epicId += 1;
        return epicId;
    }

    Integer subId(){
        subId += 1;
        return subId;
    }

//-------------------Создание,запись.-----------------------------------------------------------------------

    void createTask(Task task) {
        taskHashMap.put(task.id, task);
    }

    void createSubtask(Subtask subtask){
        subtaskHashMap.put(subtask.subIdHash,subtask);
    }

    void createEpic (Epic epic){
        epicHashMap.put(epic.id,epic);
    }

//-------------------Получение списка всех задач.-----------------------------------------------------------------------

    void getTask() {
        for (Integer key : taskHashMap.keySet()){
            Task task = taskHashMap.get(key);
                System.out.println(task.name + " " + task.id);
        }
    }

    void getSubtask() {
        for (Integer key : subtaskHashMap.keySet()){
            Subtask subtask = subtaskHashMap.get(key);
            System.out.println("Подзадача под номером " + key  + ") " + subtask.name + " " + subtask.description + " " + subtask.status);
        }
    }

    void getEpic() {
        for (Integer key:epicHashMap.keySet()){
            Epic epic = epicHashMap.get(key);
            System.out.println("Эпик под номером " + key  + ") " + epic.name + " " + epic.status);
        }
    }

//-------------------Удаление всех задач--------------------------------------------------------------------------------

    void deleteTask(){
        taskHashMap.clear();
    }

    void deleteSubtask(){
        subtaskHashMap.clear();
    }

    void deleteEpic(){
        deleteSubtask();
        epicHashMap.clear();
    }

//-------------------Получение по идентификатору------------------------------------------------------------------------

    void getTaskByIdentifier(int number){
        Task task = taskHashMap.get(number);
        System.out.println(task);
    }

    void getEpickByIdentifier(int number){
        Epic epic = epicHashMap.get(number);
        System.out.println(epic);
    }

    void getSubtaskByIdentifier(int number){
        Subtask subtask = subtaskHashMap.get(number);
        System.out.println(subtask);
    }

//-------------------Удаление по идентификатору.------------------------------------------------------------------------

    void deleteTaskByIdentifier(int number){
        taskHashMap.remove(number);
    }

    void deleteEpicByIdentifier(int number){//удаление из епика абтаск
        ArrayList<Integer> idHash = new ArrayList<>();
        for (Integer val : subtaskHashMap.keySet()){
            Subtask subtask = subtaskHashMap.get(val);
            if (number == subtask.id) {
                idHash.add(subtask.subIdHash);
            }
        }
        for (int i = 0; i < idHash.size(); i++){
            deleteSubtaskByIdentifier(idHash.get(i));
        }
        epicHashMap.remove(number);
    }

    void deleteSubtaskByIdentifier(int number){
        subtaskHashMap.remove(number);
    }

//-------------------Обновление-----------------------------------------------------------------------------------------

    void updateTask(Task task, int number){
        taskHashMap.remove(number);
        taskHashMap.put(number,task);
    }

    void updateEpic(Epic epic, int number){ // ПЕРЕДЕЛАТЬ Сделать грамотно
        ArrayList<Subtask> subtasks = new ArrayList<>();
        ArrayList<Subtask> subtasksDone = new ArrayList<>();
        ArrayList<Subtask> subtasksNew = new ArrayList<>();
        epicHashMap.remove(number);
        epicHashMap.put(number,epic);
        for (Integer kye : subtaskHashMap.keySet()){
            Subtask subtask = subtaskHashMap.get(kye);
            if (subtask.id == epic.id){
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

    void updateSubtask(Subtask subtask, int number){

        subtaskHashMap.remove(number);
        subtaskHashMap.put(number,subtask);
        updateEpic(epicHashMap.get(subtask.id),subtask.id);
    }

    void getSubtaskEpics(int number){
            System.out.println(epicHashMap.get(number));
            for (Integer keySubtask : subtaskHashMap.keySet()){
                Subtask value = subtaskHashMap.get(keySubtask);
                    if(value.id == number){
                        System.out.println(value.name + " " + value.description + " " + value.status);
                    }
            }
    }


}


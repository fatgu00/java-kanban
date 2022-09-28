package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    protected int id = 1;


//-------------------Создание,запись.-----------------------------------------------------------------------

    public void addTask(Task task) {
        tasks.put(id, task);
        task.setId(id++);
    }

    public void addSubtask(Subtask subtask, int epicId){
        subtasks.put(id,subtask);
        subtask.setId(id++);
        subtask.setEpicId(epicId);
    }

    public void addEpic (Epic epic){
        epics.put(id,epic);
        epic.subIdList.add(id);
        epic.setId(id++);
    }

//-------------------Получение списка всех задач.-----------------------------------------------------------------------

    public List<Task> getTasks() {
        List<Task> task = new ArrayList<>();
        for (Integer key:tasks.keySet()){
            task.add(tasks.get(key));
        }
        return task;
    }

    public List<Subtask> getSubtasks() {
        List<Subtask> subtask = new ArrayList<>();
        for (Integer key : subtasks.keySet()){
           subtask.add(subtasks.get(key));
        }
        return subtask;
    }

    public List<Epic> getEpics() {
        List<Epic> epic = new ArrayList<>();
        for (Integer key:epics.keySet()){
            epic.add(epics.get(key));
        }
        return epic;
    }

//-------------------Удаление всех задач--------------------------------------------------------------------------------

    private void deleteTask(){
        tasks.clear();
    }

    private void deleteSubtask(){
        subtasks.clear();
    }

    private void deleteEpic(){
        deleteSubtask();
        epics.clear();
    }

//-------------------Получение по идентификатору------------------------------------------------------------------------

    public Task getTaskById(int id){
        Task task = tasks.get(id);
        return task;
    }

    public Epic getEpicById(int id){
        Epic epic = epics.get(id);
        return epic;
    }

    public Subtask getSubtaskById(int id){
        Subtask subtask = subtasks.get(id);
        return subtask;
    }

//-------------------Удаление по идентификатору.------------------------------------------------------------------------

    public void deleteTaskById(int id){
        tasks.remove(id);
    }

    public void deleteEpicById(int id){
        ArrayList<Integer> idHash = new ArrayList<>();

        for (Integer keySubtask : subtasks.keySet()){
            Subtask value = subtasks.get(keySubtask);
            for(int a = 1; a < subtasks.size(); a++){
                if (value.getEpicId() == id) {
                    idHash.add(value.id);
                }
            }
        }
        for (int i = 0; i < idHash.size(); i++){
            deleteSubtaskById(idHash.get(i));
        }
        epics.remove(id);
    }

    public void deleteSubtaskById(int id){
        subtasks.remove(id);
    }

//-------------------Обновление-----------------------------------------------------------------------------------------

    public void updateTask(Task task){
        tasks.remove(task.id);
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic){
        ArrayList<Subtask> subtasks = new ArrayList<>();
        ArrayList<Subtask> subtasksDone = new ArrayList<>();
        ArrayList<Subtask> subtasksNew = new ArrayList<>();
        epics.remove(epic.id);
        epics.put(epic.getId(),epic);
        for (Integer kye : Manager.this.subtasks.keySet()){
            Subtask subtask = Manager.this.subtasks.get(kye);
            if (subtask.getEpicId() == epic.subIdList.get(kye)){
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

    public void updateSubtask(Subtask subtask){

        subtasks.remove(subtask.id);
        subtasks.put(subtask.getId(),subtask);

    }

    public List<Subtask> getSubtaskEpics(int id){
        List<Subtask> epicId = new ArrayList<>();
            for (Integer keySubtask : subtasks.keySet()){
                Subtask value = subtasks.get(keySubtask);
                    if(value.getEpicId() == id){
                        //subtasks.get(value.getId());
                        epicId.add(subtasks.get(keySubtask));
                    }
            }
            return epicId;
    }
}


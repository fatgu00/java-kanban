package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTaskManager implements TaskManager {

    HistoryManager managers = Managers.getDefaultHistory();

    protected Map<Integer, Task> tasks = new HashMap<>();
    protected Map<Integer, Epic> epics = new HashMap<>();
    protected Map<Integer, Subtask> subtasks = new HashMap<>();

    private int id = 1;


    //-------------------Создание,запись.-----------------------------------------------------------------------
    @Override
    public void addTask(Task task) {
        tasks.put(id, task);
        task.setId(id++);
    }

    @Override
    public void addSubtask(Subtask subtask, int epicId){
        subtasks.put(id,subtask);
        subtask.setId(id++);
        subtask.setEpicId(epicId);
    }

    @Override
    public void addEpic (Epic epic){
        epics.put(id,epic);
        epic.subId.add(id);
        epic.setId(id++);
    }

//-------------------Получение списка всех задач.-----------------------------------------------------------------------
    @Override
    public List<Task> getTasks() {
        List<Task> task = new ArrayList<>();
        for (Integer key:tasks.keySet()){
            task.add(tasks.get(key));
        }
        return task;
    }

    @Override
    public List<Subtask> getSubtasks() {
        List<Subtask> subtask = new ArrayList<>();
        for (Integer key : subtasks.keySet()){
            subtask.add(subtasks.get(key));
        }
        return subtask;
    }

    @Override
    public List<Epic> getEpics() {
        List<Epic> epic = new ArrayList<>();
        for (Integer key:epics.keySet()){
            epic.add(epics.get(key));
        }
        return epic;
    }

//-------------------Удаление всех задач--------------------------------------------------------------------------------
    @Override
    public void deleteTask(){
        tasks.clear();
    }

    @Override
    public void deleteSubtask(){
        subtasks.clear();
    }

    @Override
    public void deleteEpic(){
        deleteSubtask();
        epics.clear();
    }

//-------------------Получение по идентификатору------------------------------------------------------------------------
    @Override
    public Task getTaskById(int id){
        Task task = tasks.get(id);

        managers.add(task);
        return task;
    }

    @Override
    public Epic getEpicById(int id){
        Epic epic = epics.get(id);

        managers.add(epic);
        return epic;
    }

    @Override
    public Subtask getSubtaskById(int id){
        Subtask subtask = subtasks.get(id);

        managers.add(subtask);
        return subtask;
    }

//-------------------Удаление по идентификатору.------------------------------------------------------------------------
    @Override
    public void deleteTaskById(int id){
        tasks.remove(id);
        managers.removeHistory(id);
    }

    @Override
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
        managers.removeHistory(id);
    }

    @Override
    public void deleteSubtaskById(int id){
        subtasks.remove(id);
        managers.removeHistory(id);
    }

//-------------------Обновление-----------------------------------------------------------------------------------------
    @Override
    public void updateTask(Task task){
        tasks.remove(task.id);
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic){
        ArrayList<Subtask> subtasks = new ArrayList<>();
        ArrayList<Subtask> subtasksDone = new ArrayList<>();
        ArrayList<Subtask> subtasksNew = new ArrayList<>();
        epics.remove(epic.id);
        epics.put(epic.getId(),epic);
        for (Integer kye : InMemoryTaskManager.this.subtasks.keySet()){
            Subtask subtask = InMemoryTaskManager.this.subtasks.get(kye);
            if (subtask.getEpicId() == epic.subId.get(kye)){
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

    @Override
    public void updateSubtask(Subtask subtask){

        subtasks.remove(subtask.id);
        subtasks.put(subtask.getId(),subtask);

    }

    public List<Subtask> getSubtaskEpics(int id){
        List<Subtask> epicId = new ArrayList<>();
        for (Integer keySubtask : subtasks.keySet()){
            Subtask value = subtasks.get(keySubtask);
            if(value.getEpicId() == id){
                epicId.add(subtasks.get(keySubtask));
            }
        }
        return epicId;
    }

    public HistoryManager getManagers() {
        return managers;
    }
}

package com.company;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private List<Task> getHistory = new ArrayList<>();

    @Override
    public void add(Task task) {
        getHistory.add(task);
    }

    public List<Task> getHistory(){

        if (getHistory.size()> 10){
            getHistory.remove(0);
        }

        return getHistory;
    }
}

package com.company;
import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private List<Task> getHistory = new ArrayList<>();
    //не имею предстовление как можно еще реализовать List

    final static int LIMIT_HISTORY= 10;

    @Override
    public void add(Task task) {
        getHistory.add(task);
    }

    @Override
    public List<Task> getHistory(){

        if (getHistory.size() > LIMIT_HISTORY){
            getHistory.remove(0);
        }

        return getHistory;
    }
}

package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface HistoryManager {

    void add(Task task);
    List<Task> getHistory();
    void removeHistory(int id);
}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InMemoryHistoryManager implements HistoryManager{


    private HashMap<Integer,Node> node = new HashMap<>();

    final static int LIMIT_HISTORY= 10;

    CustomLinkedList customLinkedList = new CustomLinkedList();


    @Override
    public void add(Task task) {

        if (node.containsKey(task.id)){
            customLinkedList.removeNode(node.get(task.id));
        }
        customLinkedList.linkLast(task);
        node.put(task.id, customLinkedList.tail);
    }

    @Override

    public List<Task> getHistory(){

        if (customLinkedList.getTasks().size() > LIMIT_HISTORY){
            customLinkedList.getTasks().remove(0);
        }
        return customLinkedList.getTasks();

    }

    @Override
    public void removeHistory(int id) {

        if(!customLinkedList.getTasks().contains(node.get(id))){
            customLinkedList.getTasks().remove(node.get(id));
            if(node.containsKey(id)) {
                customLinkedList.removeNode(node.get(id));
            }
        }
    }

    class CustomLinkedList<Task>{

    private Node<Task> head;
    private Node<Task> tail;
    private int size = 0;


        void linkLast(Task task) {
            Node<Task> l = tail;
            Node<Task> newNode = new Node<>(l, task, null);
            tail = newNode;
            if (l == null)
                head = newNode;
            else
                l.next = newNode;
            size++;

        }

        ArrayList<Task> getTasks(){
            Node<Task> cur = head;
            ArrayList<Task> nodeList = new ArrayList<>();
            while (cur != null){
                nodeList.add(cur.task);
                cur = cur.next;
            }

        return nodeList;
        }

        Task removeNode(Node<Task> node) {
            final Task element = node.task;
            final Node<Task> next = node.next;
            final Node<Task> prev = node.prev;

            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
                node.prev = null;
            }

            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
                node.next = null;
            }

            node.task = null;
            size--;
            return element;
        }
    }

}
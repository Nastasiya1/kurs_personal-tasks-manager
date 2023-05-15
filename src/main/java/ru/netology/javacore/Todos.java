package ru.netology.javacore;

import java.util.TreeSet;

public class Todos {
    private final int size = 7;
    private TreeSet<String> tasks = new TreeSet<>();

    public Todos() {
    }

    public Todos(TreeSet<String> tasks) {
        this.tasks = tasks;
    }

    public TreeSet<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        for (String s : tasks) {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
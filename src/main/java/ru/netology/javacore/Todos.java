package ru.netology.javacore;

import java.util.Arrays;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

public class Todos {
    private final int size = 7;
    private String[] tasks = new String[size];

    public void addTask(String task) {
        for (int i = 0; i < size; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                break;
            }
        }
    }

    public void removeTask(String task) {
        for (int i = 0; i < size; i++) {
            if (tasks[i] != null && tasks[i].equals(task)) {
                tasks[i] = null;
            }
        }
    }

    public String getAllTasks() {
        List<String> sortedTasks = Arrays.stream(tasks)
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());

        return sortedTasks.toString();
    }
}
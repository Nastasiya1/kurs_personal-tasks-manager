package ru.netology.javacore;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        Todos todos = new Todos();
//        TodoServer server = new TodoServer(8989, todos);
//        server.start();

        Todos todos = new Todos();

        todos.addTask("Сходить в магазин");
        System.out.println(todos.getAllTasks());

        todos.addTask("Пойти на пробежку");
        System.out.println(todos.getAllTasks());

        todos.addTask("Йога");
        todos.removeTask("Пойти на пробежку");
        System.out.println(todos.getAllTasks());
    }
}
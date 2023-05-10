package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    out.println("connected");

                    Gson gson1 = new Gson();
                    String json = in.readLine();
                    Task task = gson1.fromJson(json, Task.class);
                    if (task.type == OperationType.ADD) {
                        this.todos.addTask(task.task);
                    } else if (task.type == OperationType.REMOVE) {
                        this.todos.removeTask(task.task);
                    }
                    out.println(todos.getAllTasks());
                }
            }
        }
    }
}
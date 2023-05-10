package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        List<Task> historyOfOperations = new ArrayList<>();
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

                    switch (task.type) {
                        case ADD:
                            this.todos.addTask(task.task);
                            historyOfOperations.add(task);
                            break;
                        case REMOVE:
                            this.todos.removeTask(task.task);
                            historyOfOperations.add(task);
                            break;
                        case RESTORE:
                            Task previousTask = historyOfOperations.get(historyOfOperations.size() - 1);
                            if (previousTask.type == OperationType.ADD) {
                                this.todos.removeTask(previousTask.task);
                                historyOfOperations.remove(previousTask);
                            } else if (previousTask.type == OperationType.REMOVE) {
                                this.todos.addTask(previousTask.task);
                                historyOfOperations.remove(previousTask);
                            }
                    }
                    out.println(todos.getAllTasks());
                }
            }
        }
    }
}
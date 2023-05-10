package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos testTodos;

    @Test
    void testAddTaskMethod() {
        testTodos = new Todos();
        testTodos.addTask("Шоппинг");

        String[] expected = {"Шоппинг", null, null, null, null, null, null};
        String[] actual = testTodos.getTasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveTaskMethod() {
        String[] testTasks = {"Шоппинг", null, null, null, null, null, null};
        testTodos = new Todos(testTasks);
        testTodos.removeTask("Шоппинг");

        String[] actual = {null, null, null, null, null, null, null};
        String[] expected = testTodos.getTasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testGetAllTasksMethod() {
        String[] testTasks = {"Шоппинг", null, null, null, null, null, null};
        testTodos = new Todos(testTasks);

        String actual = "Шоппинг";
        String expected = testTodos.getAllTasks();

        Assertions.assertTrue(expected.contains(actual));
    }
}
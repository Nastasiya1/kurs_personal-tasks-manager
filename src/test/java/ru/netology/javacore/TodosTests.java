package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TodosTests {
    Todos testTodos;

    @Test
    void testAddTaskMethod() {
        testTodos = new Todos();
        testTodos.addTask("Шоппинг");

        String expected = "Шоппинг";
        String actual = String.valueOf(testTodos.getTasks());

        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    void testRemoveTaskMethod() {
        TreeSet<String> testTasks = new TreeSet<>();
        testTasks.add("Шоппинг");
        testTasks.add("Йога");

        testTodos = new Todos(testTasks);

        testTodos.removeTask("Шоппинг");

        Assertions.assertFalse(testTasks.contains("Шоппинг"));
    }

    @Test
    void testGetTasksMethod() {
        TreeSet<String> testTasks = new TreeSet<>();
        testTasks.add("Шоппинг");
        testTasks.add("Йога");

        testTodos = new Todos(testTasks);
        Assertions.assertEquals(testTasks, testTodos.getTasks());
    }

    @Test
    void testGetAllTasksMethod() {
        TreeSet<String> testTasks = new TreeSet<>();
        testTasks.add("Шоппинг");
        testTasks.add("Йога");

        testTodos = new Todos(testTasks);

        String expected = "Йога Шоппинг";
        String actual = testTodos.getAllTasks();

        Assertions.assertEquals(expected, actual);
    }
}
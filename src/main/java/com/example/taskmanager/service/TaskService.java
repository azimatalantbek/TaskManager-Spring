package com.example.taskmanager.service;

import com.example.taskmanager.exception.CustomException;
import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private int taskIdCounter = 1;

    // Task Management
    public Task addTask(String name, String description) {
        Task task = new Task();
        task.setId(taskIdCounter++);
        task.setName(name);
        task.setDescription(description);
        tasks.put(task.getId(), task);
        return task;
    }

    public Task getTask(int id) {
        if (!tasks.containsKey(id)) {
            throw new CustomException("Task with id " + id + " not found.");
        }
        return tasks.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteTask(int id) {
        if (!tasks.containsKey(id)) {
            throw new CustomException("Task with id " + id + " not found.");
        }
        tasks.remove(id);
    }

    // Mathematical Operations
    public double performOperation(double num1, double num2, String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 == 0) throw new CustomException("Division by zero is not allowed.");
                return num1 / num2;
            default:
                throw new CustomException("Invalid operation: " + operation);
        }
    }

    // String Manipulations
    public Map<String, Object> manipulateString(String input) {
        if (input == null || input.isEmpty()) {
            throw new CustomException("Input string cannot be null or empty.");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("reversed", new StringBuilder(input).reverse().toString());
        result.put("vowels", input.replaceAll("[^aeiouAEIOU]", "").length());
        result.put("consonants", input.replaceAll("[aeiouAEIOU\\s]", "").length());
        result.put("uppercase", input.toUpperCase());
        result.put("lowercase", input.toLowerCase());
        return result;
    }
}

package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Task Management Endpoints
    @PostMapping("/tasks")
    public Task addTask(@RequestParam String name, @RequestParam String description) {
        return taskService.addTask(name, description);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Task deleted successfully.";
    }

    // Mathematical Operations Endpoint
    @GetMapping("/calculate")
    public double calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation) {
        return taskService.performOperation(num1, num2, operation);
    }

    // String Manipulations Endpoint
    @GetMapping("/string")
    public Map<String, Object> manipulateString(@RequestParam String input) {
        return taskService.manipulateString(input);
    }
}

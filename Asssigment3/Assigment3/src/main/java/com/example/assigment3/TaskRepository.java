package com.example.assigment3;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class TaskRepository {

    private final String jsonFilePath = "src/main/resources/tasks.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Task> getAllTasks() {
        try {
            File file = new File(jsonFilePath);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Task getTaskById(Long taskId) {
        return getAllTasks().stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }

    public void addTask(Task task) {
        List<Task> tasks = getAllTasks();
        tasks.add(task);
        saveTasks(tasks);
    }

    public void updateTask(Task updatedTask) {
        List<Task> tasks = getAllTasks();
        tasks.removeIf(task -> task.getId().equals(updatedTask.getId()));
        tasks.add(updatedTask);
        saveTasks(tasks);
    }

    public void deleteTask(Long taskId) {
        List<Task> tasks = getAllTasks();
        tasks.removeIf(task -> task.getId().equals(taskId));
        saveTasks(tasks);
    }

    private void saveTasks(List<Task> tasks) {
        try {
            objectMapper.writeValue(new File(jsonFilePath), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


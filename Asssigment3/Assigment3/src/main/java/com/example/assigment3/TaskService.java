package com.example.assigment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public void updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.getTaskById(taskId);
        if (existingTask != null) {
            updatedTask.setId(taskId);
            taskRepository.updateTask(updatedTask);
        }
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteTask(taskId);
    }
}

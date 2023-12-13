package com.example.assigment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskRepository.getTaskById(taskId);
    }



    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskRepository.addTask(task);
    }

    @PutMapping("/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        if (taskRepository.getTaskById(taskId) != null) {
            updatedTask.setId(taskId);
            taskRepository.updateTask(updatedTask);
        }
    }


    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskRepository.deleteTask(taskId);
    }
}

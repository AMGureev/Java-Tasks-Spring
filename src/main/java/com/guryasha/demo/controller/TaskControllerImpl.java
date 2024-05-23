package com.guryasha.demo.controller;

import com.guryasha.demo.entity.TaskDaoImpl;
import com.guryasha.demo.entity.TaskEntity;
import com.guryasha.demo.service.TaskService;
import com.guryasha.demo.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskControllerImpl implements TaskController{
    private TaskService taskService = new TaskServiceImpl(new TaskDaoImpl());

    @GetMapping("/all")
    @Override
    public Iterable<TaskEntity> returnAllTasks() {
        return taskService.returnAllTasks();
    }

    @GetMapping("/taskById")
    @Override
    public TaskEntity returnTaskById(@RequestParam int id) {
        return taskService.returnTaskById(id);
    }

    @GetMapping("/add")
    @Override
    public TaskEntity addTask(@RequestParam String title, @RequestParam String desc) {
        return taskService.addTask(title, desc);
    }

    @GetMapping("/delete")
    @Override
    public void deleteTaskById(@RequestParam int id) {
        taskService.deleteTaskById(id);
    }
}

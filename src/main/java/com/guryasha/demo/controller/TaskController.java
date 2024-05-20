package com.guryasha.demo.controller;

import com.guryasha.demo.entity.TaskEntity;

public interface TaskController {
    Iterable<TaskEntity> returnAllTasks(); // return all tasks
    TaskEntity returnTaskById(int id); // return task by id
    TaskEntity addTask(String title, String desc); // add task to list
    void deleteTaskById(int id); // delete task by id
}

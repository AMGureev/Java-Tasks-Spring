package com.guryasha.demo.entity;

public interface TaskDao {
    Iterable<TaskEntity> returnAllTasks(); // return all tasks
    TaskEntity returnTaskById(int id); // return task by id
    TaskEntity addTask(String title, String desc); // add task to list
    void deleteTaskById(int id); // delete task by id
    int countRow();
}

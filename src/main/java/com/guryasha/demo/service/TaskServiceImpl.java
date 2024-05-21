package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskDaoImpl;
import com.guryasha.demo.entity.TaskEntity;
import com.guryasha.demo.exception.NonExistentObjectException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskDaoImpl taskDao = new TaskDaoImpl();


    @Override
    public Iterable<TaskEntity> returnAllTasks() {
        return taskDao.returnAllTasks();
    }

    @Override
    public TaskEntity returnTaskById(int id) {
        return taskDao.returnTaskById(id);
    }

    @Override
    public TaskEntity addTask(String title, String desc) {
        return taskDao.addTask(title, desc);
    }

    @Override
    public void deleteTaskById(int id) {
        taskDao.deleteTaskById(id);
    }
}

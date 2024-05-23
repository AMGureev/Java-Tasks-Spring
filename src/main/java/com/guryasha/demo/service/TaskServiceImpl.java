package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskDao;
import com.guryasha.demo.entity.TaskDaoImpl;
import com.guryasha.demo.entity.TaskEntity;
import com.guryasha.demo.exception.NonExistentObjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    private TaskDao taskDao;


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
    @Override
    public int returnCountRow() { return taskDao.countRow();}

    public TaskServiceImpl(TaskDao taskDao) {this.taskDao = taskDao;}
}

package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskEntity;
import com.guryasha.demo.exception.NonExistentObjectException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private List<TaskEntity> list = new LinkedList<>();
    private int lastId = 0;

    @Override
    public Iterable<TaskEntity> returnAllTasks() {
        return list;
    }

    @Override
    public TaskEntity returnTaskById(int id) {
        TaskEntity obj = list.stream().filter(list -> id == (list.getId())).findFirst().orElse(null);
        if (obj == null) {
            throw new NonExistentObjectException();
        }
        return obj;
    }

    @Override
    public TaskEntity addTask(String title, String desc) {
        TaskEntity newTask = new TaskEntity(title, desc);
        newTask.setId(lastId++);
        list.add(newTask);
        return newTask;
    }

    @Override
    public void deleteTaskById(int id) {
        TaskEntity obj = list.stream().filter(list -> id == (list.getId())).findFirst().orElse(null);
        if (obj == null) {
            // error
        } else {
            list.remove(obj);
            // TODO остальные записи имеют индекс на -1.
        }
    }
}

package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService taskService = new TaskServiceImpl();

    @Test
    void addTask__success() {
        TaskEntity task = new TaskEntity("TITLE", "DESCRIPTION");
        task.setId(25);
        var add = taskService.addTask("TITLE", "DESCRIPTION");
        assertEquals(task, add);
    }

    @Test
    void deleteTask__success() { // удаление существующей таски
        int count_pr = taskService.returnCountRow();
        taskService.deleteTaskById(19);
        int count_cur = taskService.returnCountRow();
        assertNotEquals(count_cur, count_pr);
    }

    @Test
    void deleteTask__failed() { // удаление несуществующей таски (такого id нет)
        int count_pr = taskService.returnCountRow();
        taskService.deleteTaskById(1);
        int count_cur = taskService.returnCountRow();
        assertEquals(count_pr, count_cur);
    }

    @Test
    void returnById__success() {
        TaskEntity task = new TaskEntity("TITLE", "DESCRIPTION");
        var add = taskService.returnTaskById(20);
        assertEquals(task, add);
    }

    @Test
    void returnAllTasks__success() {
        List<TaskEntity> list_pr = new LinkedList<>();
        TaskEntity task_first = new TaskEntity("TITLE", "DESCRIPTION");
        task_first.setId(26);
        list_pr.add(task_first);
        TaskEntity task_second = new TaskEntity("TITLE", "DESCRIPTION");
        task_second.setId(27);
        list_pr.add(task_second);
        Iterable<TaskEntity> list_cur = taskService.returnAllTasks();
        assertIterableEquals(list_pr, list_cur);
    }

//    @Test
//    void returnAllTasks__failed() {
//        List<TaskEntity> list_pr = new LinkedList<>();
//        TaskEntity task_first = new TaskEntity("TITLE", "DESCRIPTION");
//        task_first.setId(26);
//        list_pr.add(task_first);
//        TaskEntity task_second = new TaskEntity("TITLE", "DESCRIPTION2");
//        task_second.setId(27);
//        list_pr.add(task_second);
//        Iterable<TaskEntity> list_cur = taskService.returnAllTasks();
//        assertIterableEquals(list_pr, list_cur);
//    }
}
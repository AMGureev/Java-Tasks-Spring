package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {
    private TaskService taskService = new TaskServiceImpl();

    @Test
    void addTask__success() {
        var add = taskService.addTask("TITLE", "DESCRIPTION");
        assertEquals(new TaskEntity("TITLE", "DESCRIPTION"), add);
    }
}

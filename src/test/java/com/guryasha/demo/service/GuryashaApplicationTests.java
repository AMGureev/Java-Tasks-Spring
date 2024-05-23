package com.guryasha.demo.service;

import com.guryasha.demo.entity.TaskDao;
import com.guryasha.demo.entity.TaskEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Provider;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class GuryashaApplicationTests {

	@Mock
	TaskDao taskDao;
	@InjectMocks
	TaskServiceImpl	taskService;
	@Test
	public void addTask__success() {
		Mockito.when(taskDao.addTask("Title", "Desc"))
				.thenReturn(new TaskEntity(1,"Title", "Desc"));
		Mockito.when(taskDao.addTask("Title1", "Desc1"))
				.thenReturn(new TaskEntity(2, "Title1", "Desc1"));
		Mockito.when(taskDao.addTask("Title2", "Desc2"))
				.thenReturn(new TaskEntity(3, "Title2", "Desc2"));
		TaskEntity task0 = taskDao.addTask("Title", "Desc");
		TaskEntity task1 = new TaskEntity(1, "Title", "Desc");
		Assertions.assertEquals(task1, taskService.addTask("Title", "Desc"));
		TaskEntity task2 = new TaskEntity(2, "Title1", "Desc1");
		Assertions.assertEquals(task2, taskService.addTask("Title1", "Desc1"));
		TaskEntity task3 = new TaskEntity(3, "Title2", "Desc2");
		Assertions.assertEquals(task3, taskService.addTask("Title2", "Desc2"));

		Mockito.verify(taskDao, Mockito.times(1)).addTask("Title", "Desc");
		Mockito.verify(taskDao, Mockito.times(1)).addTask("Title1", "Desc1");
		Mockito.verify(taskDao, Mockito.times(1)).addTask("Title2", "Desc2");

		System.out.println("TEST_FIRST_SUCCESSFUL");
	}

//	private TaskService taskService = new TaskServiceImpl();
//
//	@Test
//	void addTask__success() {
//		TaskEntity task = new TaskEntity("TITLE", "DESCRIPTION");
//		task.setId(25);
//		var add = taskService.addTask("TITLE", "DESCRIPTION");
//		assertEquals(task, add);
//	}
//
//	@Test
//	void deleteTask__success() { // удаление существующей таски
//		int count_pr = taskService.returnCountRow();
//		taskService.deleteTaskById(19);
//		int count_cur = taskService.returnCountRow();
//		assertNotEquals(count_cur, count_pr);
//	}
//
//	@Test
//	void deleteTask__failed() { // удаление несуществующей таски (такого id нет)
//		int count_pr = taskService.returnCountRow();
//		taskService.deleteTaskById(1);
//		int count_cur = taskService.returnCountRow();
//		assertEquals(count_pr, count_cur);
//	}
//
//	@Test
//	void returnById__success() {
//		TaskEntity task = new TaskEntity("TITLE", "DESCRIPTION");
//		var add = taskService.returnTaskById(20);
//		assertEquals(task, add);
//	}
//
//	@Test
//	void returnAllTasks__success() {
//		List<TaskEntity> list_pr = new LinkedList<>();
//		TaskEntity task_first = new TaskEntity("TITLE", "DESCRIPTION");
//		task_first.setId(26);
//		list_pr.add(task_first);
//		TaskEntity task_second = new TaskEntity("TITLE", "DESCRIPTION");
//		task_second.setId(27);
//		list_pr.add(task_second);
//		Iterable<TaskEntity> list_cur = taskService.returnAllTasks();
//		assertIterableEquals(list_pr, list_cur);
//	}

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
	@Test
	void contextLoads() {

	}

}

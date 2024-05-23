package com.guryasha.demo.entity;

import com.guryasha.demo.exception.NonExistentObjectException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TaskDaoImpl implements TaskDao{
    Connection connection = null;
    String user_name = "postgres";
    String password = "Suck228";
    String table_name = "tasks_table";
    public TaskDaoImpl() {
        try{
            Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/users_tasks", user_name, password
            );
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks_table");
//            while (rs != null && rs.next()) {
//                TaskEntity task = new TaskEntity(rs.getString("title"), rs.getString("description"));
//                list.add(task);
//            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ASSSSS");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterable<TaskEntity> returnAllTasks() {
        String request = String.format(
                "SELECT * FROM %s " , table_name);
        List<TaskEntity> list = new LinkedList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement(request);
            ResultSet rs = stmt.executeQuery();
            while (rs != null && rs.next()) {
                TaskEntity task = new TaskEntity(rs.getString("title"), rs.getString("description"));
                task.setId(rs.getInt("id"));
                list.add(task);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskEntity returnTaskById(int id) {
        String request = String.format("SELECT * FROM %s WHERE id = %d", table_name, id);
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet rs = statement.executeQuery();
            System.out.println("111");
            if (rs != null) {
                rs.next();
                TaskEntity task = new TaskEntity(rs.getString("title"), rs.getString("description"));
                task.setId(id);
                return task;
            } else {
                throw new NonExistentObjectException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TaskEntity addTask(String title, String desc) {
        String request = String.format("INSERT INTO %s(description, title) VALUES('%s', '%s')", table_name, desc, title);
        String request_max = String.format("SELECT MAX(id) FROM %s", table_name);
        try {
            PreparedStatement statement_first = connection.prepareStatement(request);
            statement_first.executeUpdate();
            PreparedStatement statement_second = connection.prepareStatement(request_max);
            ResultSet rs = statement_second.executeQuery();
            TaskEntity task =  new TaskEntity(title, desc);
            rs.next();
            task.setId(rs.getInt(1));
            return task;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaskById(int id) {
        String request = String.format("DELETE FROM %s WHERE id = %d", table_name, id);
        try {
            PreparedStatement  statement = connection.prepareStatement(request);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int countRow() {
        String request = String.format("SELECT COUNT(id) FROM %s", table_name);
        try {
            PreparedStatement statement = connection.prepareStatement(request);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package ProgForce.repository.dao;

import ProgForce.domain.Task;

import java.sql.SQLException;
import java.util.List;


public interface TaskDAO {
    public void addTask(Task task) throws SQLException;
    public void deleteTask(int id) throws SQLException;
    public void updateTask(Task task) throws SQLException;
    public List<Task> getAllTask() throws SQLException;
    public Task findTaskById(int id) throws SQLException;
}

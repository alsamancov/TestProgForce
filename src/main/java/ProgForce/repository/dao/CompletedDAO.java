package ProgForce.repository.dao;


import ProgForce.domain.Completed;

import java.sql.SQLException;
import java.util.List;

public interface CompletedDAO {
    public void addCompleted(Completed completed) throws SQLException;
    public void deleteCompleted(Completed completed) throws SQLException;
    public void updateCompleted(Completed completed) throws SQLException;
    public List<Completed> getAllCompleted() throws SQLException;
    public Completed findCompletedById(int id) throws SQLException;
}

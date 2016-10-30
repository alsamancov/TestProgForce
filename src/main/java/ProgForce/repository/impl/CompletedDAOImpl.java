package ProgForce.repository.impl;

import ProgForce.domain.Completed;
import ProgForce.repository.dao.CompletedDAO;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CompletedDAOImpl implements CompletedDAO {
    public void addCompleted(Completed completed) throws SQLException {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        Connection connection = null;
        Statement statement = null;
        try{
            inputStream = new FileInputStream("db.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = "INSERT INTO completed (NAME, DATE, PRIORITY) VALUES ('" +
                    completed.getName() + "', '" +
                    completed.getInitDate() + "', " +
                    completed.getPriority() + ");";
            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
            connection.close();
        } catch(Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }

    }

    public List<Completed> getAllCompleted() throws SQLException {
        List<Completed> list = new ArrayList<Completed>();
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        Connection connection = null;
        Statement statement = null;
        try{
            inputStream = new FileInputStream("db.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM completed;");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                int priority = resultSet.getInt("priority");

                list.add(new Completed((long) id, name, date, priority));


            }
        } catch(Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }
        return list;
    }

    public void deleteCompleted(Completed completed) throws SQLException {

    }

    public void updateCompleted(Completed completed) throws SQLException {

    }

    public Completed findCompletedById(String id) throws SQLException {
        return null;
    }
}

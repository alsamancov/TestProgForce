package ProgForce.repository.impl;

import ProgForce.domain.Task;
import ProgForce.repository.dao.TaskDAO;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class TaskDAOImpl implements TaskDAO {
    public void addTask(Task task) throws SQLException {
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
            String sql = "INSERT INTO task (NAME, DATE, PRIORITY) VALUES ('" +
                    task.getName() + "', '"
                    + task.getDate() + "', "
                    + task.getPriority() + ");";
            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
            connection.close();
        }catch (Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }

    }

    public void deleteTask(int id) throws SQLException {
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
                    properties.getProperty("DB_PASSWORD")
            );
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            String sql = "DELETE FROM task WHERE ID=" + id + ";";
            statement.executeUpdate(sql);
            connection.commit();

            statement.close();
            connection.close();
        } catch (Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }

    }

    public void updateTask(Task task) throws SQLException {

    }

    public List<Task> getAllTask() throws SQLException {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        List<Task> list = new ArrayList<Task>();
        Connection connection = null;
        Statement statement = null;
        try{
            inputStream = new FileInputStream("db.properties");
            properties.load(inputStream);
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM task;");
            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                int priority = resultSet.getInt("priority");
                list.add(new Task(id, name, date, priority));


            }
        } catch (Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }
        return list;
    }

    public Task findTaskById(int id) throws SQLException {
        Task task = null;
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

            ResultSet resultSet = statement.executeQuery("SELECT * FROM task WHERE ID=" + id + ";");
            while(resultSet.next()){
                task = new Task(resultSet.getString("name"), resultSet.getDate("date"), resultSet.getInt("priority"));
            }

            connection.commit();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception problem){
            problem.printStackTrace();
            System.exit(0);
        }
        return task;
    }
}

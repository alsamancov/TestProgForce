package ProgForce.controller;


import ProgForce.domain.Completed;
import ProgForce.domain.Task;
import ProgForce.repository.impl.CompletedDAOImpl;
import ProgForce.repository.impl.TaskDAOImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private Scanner input = new Scanner(System.in);

    TaskDAOImpl taskDao = new TaskDAOImpl();
    CompletedDAOImpl completedDAO = new CompletedDAOImpl();

    public void showMainMenu() throws IOException, SQLException {
        System.out.println("    Main Menu    ");
        System.out.println("1. Add task");
        System.out.println("2. Print a list of tasks");
        System.out.println("3. Exit");

        int selection = input.nextInt();
        input.nextLine();

        switch(selection){
            case 1:
                this.add();
                break;
            case 2:
                this.getTasks();
                break;
            case 3:
                this.exit();
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
    }

    private void exit() {
        System.out.println("Exiting...");
        System.exit(1);
    }

    private void getTasks() throws SQLException, IOException {
        List<Task> list = taskDao.getAllTask();
        System.out.println("                Screen Menu");
        System.out.printf("%-10s %-20s %-15s %-10s %-10s %n", "ID", "NAME", "DATE", "PRIORITY", "OVERDUE");

        for(Task tasks : list){
            System.out.printf("%10d %20s %15s %10d %10s %n",
                    tasks.getId(), tasks.getName(), tasks.getDate(),
                    tasks.getPriority(), tasks.isOverdue());
        }

        showScreenMenu();
    }

    private void showScreenMenu() throws IOException, SQLException {
        while(true){
            System.out.println();
            System.out.println("============================");
            System.out.println("1. Choose completed task by ID: ");
            System.out.println("2. Show completed tasks");
            System.out.println("3. Return on Main Menu");

            int selection = input.nextInt();
            input.nextLine();

            switch(selection){
                case 1:
                    this.completeTask();
                    break;
                case 2:
                    this.showCompleted();
                    break;
                case 3:
                    this.showMainMenu();
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }
    }

    private void showCompleted() throws SQLException, IOException {
        List<Completed> list = completedDAO.getAllCompleted();
        System.out.println("                Screen Menu");
        System.out.printf("%-10s %-20s %-15s %-10s %n", "ID", "NAME", "DATE", "PRIORITY");

        for(Completed completeds : list){
            System.out.printf("%10d %20s %15s %10d %n",
                    completeds.getId(), completeds.getName(),
                    completeds.getInitDate(), completeds.getPriority());
        }

        showScreenMenu();
    }

    private void completeTask() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose completed task by ID");
        int choosedId = Integer.parseInt(reader.readLine());
        Task task = taskDao.findTaskById(choosedId);
        Completed completed = new Completed(task.getName(), task.getDate(), task.getPriority());
        completedDAO.addCompleted(completed);
        taskDao.deleteTask(choosedId);
        System.out.println("    Screen Menu    ");
        taskDao.getAllTask();
        showScreenMenu();
    }

    private void add() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of task (no more than 50 characters):");
        String name = reader.readLine();
        System.out.println("Enter completion date if format "yyyy-MM-dd":");
        Date date = null;
        Date formatteddate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = reader.readLine();
        try {
            date = dateFormat.parse(dateString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter priority of the task number between 1 and 4 inclusive:");
        int priority = Integer.parseInt(reader.readLine());
        /**
         * get all init params in proper type
         */
        Task task = new Task(name, date, priority);
        taskDao.addTask(task);
        showMainMenu();
    }
}

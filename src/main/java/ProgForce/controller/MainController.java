package ProgForce.controller;


import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    public static void main( String[] args ) throws IOException, SQLException {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        while(true){
            consoleMenu.showMainMenu();
        }
    }
}

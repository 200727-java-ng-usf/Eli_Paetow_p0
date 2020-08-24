package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.AppDriver.app;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Welcome to Eli's Bank");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");


        try {
            System.out.print("> ");
            String userSelection = console.readLine();

            switch (userSelection) {
                case "1":
                    app.getRouter().navigate("/login");

                    break;

                case "2":
                    app.getRouter().navigate("/register");
                    break;
                case "3":
                    app.setAppRunning(false);
                    break;
                default:
                    System.out.println("invalid selcection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

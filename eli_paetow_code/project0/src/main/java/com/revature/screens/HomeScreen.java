package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.AppDriver.app;

public class HomeScreen extends Screen {

    /*
     *set up name and route to be used
     * */

    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {

        /*
         *remove this later
         * */
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        /*
         *welcome to the homescreen
         * options to login or register
         * */
        System.out.println("Welcome to Eli's Bank");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");


        try {
            System.out.print("> ");
            String userSelection = console.readLine();

            /*
             *route user based off selection
             * */
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
                    System.out.println("invalid selection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

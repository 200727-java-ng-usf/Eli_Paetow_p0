package com.revature.screens;

import com.revature.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.revature.AppDriver.app;

public class LoginScreen extends Screen {

    private UserService userService;

    /*
     *set up name and route to be used
     * */
    // Inject the dependency through the constructor (constructor injection)
    public LoginScreen(UserService userService) {

        super("LoginScreen", "/login");

        // loosely coupled, because this class is not responsible for instantiation of a UserService
        this.userService = userService;
    }


    @Override
    public void render() {

        String username, password;

        /*
         *user selected login
         * prompt for username and password
         * */
        try {
            System.out.println("Welcome back to Eli's Bank! ");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = app.getConsole().readLine();
            System.out.print("Password: ");
            password = app.getConsole().readLine();

            /*
             *check to see if user input is valid
             * */
            userService.authenticate(username, password);

            /*
             *if valid then take user to their dashboard
             * */
            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

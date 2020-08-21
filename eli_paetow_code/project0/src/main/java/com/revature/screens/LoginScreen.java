package com.revature.screens;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginScreen extends Screen {

    private UserService userService;

    // Inject the dependency through the constructor (constructor injection)
    public LoginScreen(UserService userService) {

        super(LoginSceen, )
        System.out.println("[LOG] - Instantiating " + this.getClass().getName());

        // loosely coupled, because this class is not responsible for instantiation of a UserService
        this.userService = userService;
    }
    @Override
    public void render() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String username, password;

        try {
            System.out.println("Welcome back to Eli's Bank! ");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

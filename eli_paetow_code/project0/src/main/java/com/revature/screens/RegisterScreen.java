package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.AppDriver.app;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("Register Screen is running");

        this.userService = userService;

    }

    @Override
    public void render() {
        String firstName, lastName, username, password, email;

        try {
            System.out.println("Sign up for a new account!");
            System.out.print("First name: ");
            firstName = app.getConsole().readLine();
            System.out.print("Last name: ");
            lastName = app.getConsole().readLine();
            System.out.print("Username: ");
            username = app.getConsole().readLine();
            System.out.print("Password: ");
            password = app.getConsole().readLine();
            System.out.print("email: ");
            email = app.getConsole().readLine();


            AppUser newUser = new AppUser(firstName, lastName, username, password, email);
            userService.register(newUser);

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException e) {
            System.err.println("Registration unsuccessful, invalid values provided.");
        } catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred: " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            app.setAppRunning(false);
        }
    }


}


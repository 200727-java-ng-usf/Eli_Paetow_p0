package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.services.UserService;

import static com.revature.AppDriver.app;

public class RegisterScreen extends Screen {

    private UserService userService;


    /*
     *set up name and route to be used
     * */
    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");

        this.userService = userService;

    }

    @Override
    public void render() {
        String firstName, lastName, username, password, email;

        /*
         *user decided to register
         * take in values for all fields
         * */
        try {
            System.out.println("");
            System.out.println("------------------------");
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



            /*
             *finish creating the user
             * */

            AppUser newUser = new AppUser(firstName, lastName, username, password, email);
            userService.register(newUser);

            /*
             *return to dashboard iff all values are valid
             * */

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException e) {
            System.err.println("Registration unsuccessful, invalid values provided.");
        } catch (Exception e) {
            /*
             *shut down and set app running to false if error occurs
             * */
            System.err.println("[ERROR] - An unexpected exception occurred: " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            app.setAppRunning(false);
        }
    }


}


package com.revature.screens;

import java.io.IOException;
import static com.revature.AppDriver.app;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("instantiating" + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to your Dashboard!\n");
        System.out.println("1) Deposit funds into your account");
        System.out.println("2) Withdraw funds from your account");
        System.out.println("3) View the balance of your account");
        System.out.println("4) Logout");

        try {
            System.out.print("> ");
            String userSelection = app.getConsole().readLine().trim();

            switch (userSelection) {
                case "1":
                    System.out.println("deposit");
                    break;
                case "2":
                    System.out.println("Withdraw");
                    break;
                case "3":
                    System.out.println("View the balance");
                    break;
                case "4":
                    app.getRouter().navigate("/home");
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
                    app.getRouter().navigate("/dashboard");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.revature.screens;

import java.io.IOException;

import static com.revature.AppDriver.app;

public class DashboardScreen extends Screen {


    /*
     *set up name and route to be used
     * */
    public DashboardScreen() {

        super("DashboardScreen", "/dashboard");
    }

    /*
     *offer the user options to use their account
     * */
    @Override
    public void render() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Welcome to your Dashboard!");
        System.out.println("1) Deposit funds into your account");
        System.out.println("2) Withdraw funds from your account");
        System.out.println("3) View the balance of your account");
        System.out.println("4) Create a new account");
        System.out.println("5) Logout");

        try {
            System.out.print("> ");
            String userSelection = app.getConsole().readLine().trim();

            /*
             *routes the user based off their selection
             * */
            switch (userSelection) {
                case "1":
                    System.out.println("deposit");
                    app.getRouter().navigate("/deposit");
                    break;
                case "2":
                    System.out.println("Withdraw");
                    app.getRouter().navigate("/withdraw");
                    break;
                case "3":
                    System.out.println("View the balance");
                    app.getRouter().navigate("/balanceView");
                    break;
                case "4":
                    app.getRouter().navigate("/createNewAccount");
                    break;
                case "5":
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

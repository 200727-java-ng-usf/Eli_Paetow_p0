package com.revature.screens;

import com.revature.services.AccountService;

import java.io.IOException;

import static com.revature.AppDriver.app;

public class DepositScreen extends Screen {


    private AccountService accountService;

    public DepositScreen(AccountService accountService) {
        super("DepositScreen", "/deposit");
        System.out.println("instantiating" + super.getName());

        this.accountService = accountService;
    }


    @Override
    public void render() {

        double deposit = 0.0d;

        System.out.println("Welcome to the Deposit Screen");
        System.out.print("Enter the amount to be deposited: ");

        try {
//            String deposit = app.getConsole().readLine().trim();
            deposit = Double.parseDouble(app.getConsole().readLine());

            if (deposit == 0) {

                System.out.println("you cant deposit 0 dollars");

            }else{

                accountService.depositAmount(app.getCurrentAccount(), deposit);

                System.out.println("thank you for your deposit");
            }


        } catch (IOException e) {
            System.out.println("You've entered an invalid number.");
        }
        if (app.isSessionValid()){
            app.getRouter().navigate("/dashboard");
        }


    }


}

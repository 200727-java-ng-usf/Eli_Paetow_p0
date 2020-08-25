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

        int userInput = 0;
        double deposit = 0.0d;

        System.out.println("Welcome to the Deposit Screen");
        System.out.print("Enter your account id to be deposited: ");

        try{
            userInput = Integer.parseInt(app.getConsole().readLine());
            accountService.authenticate(userInput);

        }catch(IOException e){
            e.printStackTrace();
        }


        try {



            System.out.print("Enter your account id to be deposited: ");

            deposit = Double.parseDouble(app.getConsole().readLine());

            if (deposit == 0) {

                System.out.println("you cant deposit 0 dollars");

            } else {

                accountService.depositAmount(app.getCurrentAccount(), deposit);

                System.out.println("thank you for your deposit");
            }


        } catch (IOException e) {
            System.out.println("You've entered an invalid number.");
        }
        if (app.isSessionValid()) {
            app.getRouter().navigate("/dashboard");
        }


    }


}

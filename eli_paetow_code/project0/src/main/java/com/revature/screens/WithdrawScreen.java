package com.revature.screens;

import com.revature.services.AccountService;

import static com.revature.AppDriver.app;

public class WithdrawScreen extends Screen {


    private AccountService accountService;

    public WithdrawScreen(AccountService accountService) {
        super("WithdrawScreen", "/withdraw");
        System.out.println("instantiating" + super.getName());

        this.accountService = accountService;
    }

    @Override
    public void render() {
        System.out.println("Welcome to the Withdraw Screen");
        System.out.println("Enter your account id to withdraw from: ");
        try {
            Integer userInput = 0;
            Double withdrawAmount = 0.0d;
            userInput = Integer.parseInt(app.getConsole().readLine());
            accountService.authenticate(userInput);

            System.out.println("Enter the amount you'd like to withdraw: ");

            try {
                withdrawAmount = Double.parseDouble(app.getConsole().readLine());

            } catch (Exception e) {
                System.out.println("invalid input");
            }
            accountService.withdrawMethod(app.getCurrentAccount(), withdrawAmount);

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }
        } catch (
                Exception e) {
            System.out.println("error");
        }
    }
}

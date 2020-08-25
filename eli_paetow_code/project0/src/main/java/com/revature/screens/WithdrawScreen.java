package com.revature.screens;

import com.revature.services.AccountService;

import static com.revature.AppDriver.app;

public class WithdrawScreen extends Screen {


    private AccountService accountService;


    /*
     *set up name and route to be used
     * */
    public WithdrawScreen(AccountService accountService) {
        super("WithdrawScreen", "/withdraw");

        this.accountService = accountService;
    }

    @Override
    public void render() {
        System.out.println("Welcome to the Withdraw Screen");

        /*
         *enter in the id they want to withdraw from
         * */
        System.out.println("Enter your account id to withdraw from: ");
        try {
            Integer userInput = 0;
            Double withdrawAmount = 0.0d;
            userInput = Integer.parseInt(app.getConsole().readLine());

            /*
             *check if id is valid
             * */
            accountService.authenticate(userInput);

            /*
             *amount they want to witdraw
             * */

            System.out.println("Enter the amount you'd like to withdraw: ");

            try {
                withdrawAmount = Double.parseDouble(app.getConsole().readLine());

            } catch (Exception e) {
                System.out.println("invalid input");
            }

            /*
             *if input is valid then use teh withdraw method
             * */
            accountService.withdrawMethod(app.getCurrentAccount(), withdrawAmount);


            /*
             *return to dashboard
             * */
            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }
        } catch (
                Exception e) {
            System.out.println("error");
        }
    }
}

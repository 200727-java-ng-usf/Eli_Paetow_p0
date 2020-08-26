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
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Welcome to the Withdraw Screen");
        System.out.println("------------------------");


        /*
         *enter in the id they want to withdraw from
         * */
        try {
            Integer userInput = 0;
            Double withdrawAmount = 0.0d;


            System.out.print("Enter the amount you'd like to withdraw: ");

            System.out.println("------------------------");

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

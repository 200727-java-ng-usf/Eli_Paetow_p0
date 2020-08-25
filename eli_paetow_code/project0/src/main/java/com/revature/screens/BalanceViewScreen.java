package com.revature.screens;

import com.revature.services.AccountService;

import static com.revature.AppDriver.app;

public class BalanceViewScreen extends Screen {


    private AccountService accountService;

    /*
     *set up name and route to be used
     * */
    public BalanceViewScreen(AccountService accountService) {
        super("BalanceViewScreen", "/balanceView");

        this.accountService = accountService;
    }

    /*
     *display balance and then return to the dashboard
     * */
    @Override
    public void render() {
        System.out.println("View your balance below ");
        System.out.println(app.getCurrentAccount());

        if (app.isSessionValid()) {
            app.getRouter().navigate("/dashboard");
        }



    }
}
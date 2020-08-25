package com.revature.screens;

import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

import javax.jws.soap.SOAPBinding;

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
        Integer id =0;
        try {
            id = app.getCurrentAccount().getId();

            accountService.viewBalance(id);

        } catch (Exception e){
            System.out.println("there has been an error viewing balance");
        }

        if (app.isSessionValid()) {
            app.getRouter().navigate("/dashboard");
        }


    }


}
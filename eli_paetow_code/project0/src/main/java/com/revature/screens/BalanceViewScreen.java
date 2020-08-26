package com.revature.screens;

import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;

import javax.jws.soap.SOAPBinding;

import java.io.IOException;

import static com.revature.AppDriver.app;

public class BalanceViewScreen extends Screen {


    private AccountService accountService;
    private AccountRepository accountRepository;

    /*
     *set up name and route to be used
     * also constructor injecting
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
        int userInput = 0;
        System.out.println("------------------------");

        System.out.println("View your balance screen ");
        System.out.println("------------------------");


        try {

            System.out.println("To validate your account please enter your account id :");

            System.out.print("> ");

            userInput = Integer.parseInt(app.getConsole().readLine());

            accountService.authenticate(userInput);
            System.out.println("------------------------");
            System.out.println("View your balance below");


            accountService.viewBalance(app.getCurrentAccount());


        } catch (Exception e) {
            e.printStackTrace();
        }


        if (app.isSessionValid()) {
            app.getRouter().navigate("/dashboard");
        }


    }


}
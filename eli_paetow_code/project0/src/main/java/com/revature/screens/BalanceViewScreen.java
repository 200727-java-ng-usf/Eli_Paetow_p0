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
        System.out.print("Enter your account id to be deposited: ");

        Integer id =1;
        try{
            accountRepository.findBalance(1);


        }catch(Exception e){
            e.printStackTrace();
        }


        if (app.isSessionValid()) {
            app.getRouter().navigate("/dashboard");
        }


    }


}
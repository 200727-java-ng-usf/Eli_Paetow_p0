package com.revature.screens;

import com.revature.services.AccountService;

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


    }
}

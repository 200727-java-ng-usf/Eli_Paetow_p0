package com.revature.screens;

import com.revature.services.AccountService;

public class BalanceViewScreen extends Screen {


    private AccountService accountService;

    public BalanceViewScreen(AccountService accountService) {
        super("BalanceViewScreen", "/balanceView");
        System.out.println("instantiating" + super.getName());

        this.accountService = accountService;
    }

    @Override
    public void render() {
        System.out.println("View your balance below");


    }
}
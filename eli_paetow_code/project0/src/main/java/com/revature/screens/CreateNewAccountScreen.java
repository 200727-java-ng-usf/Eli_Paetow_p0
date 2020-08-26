package com.revature.screens;

import com.revature.models.AppUser;
import com.revature.models.UserAccount;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import static com.revature.AppDriver.app;

public class CreateNewAccountScreen extends Screen {


    private AccountService accountService;

    private UserAccount userAccount;

    public CreateNewAccountScreen(AccountService accountService) {
        super("CreateNewAccountScreen", "/createNewAccount");
        this.accountService = accountService;
    }


    @Override
    public void render() {
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("Create a new account");

        try {

            UserAccount newAccount = new UserAccount(18 , 0.0d, 4);


            accountService.createNewAccount(newAccount);

            System.out.println("Thank you for creating a new account");
            System.out.println("------------------------");
            System.out.println("you have a balance of $0.00");

            /*
             *return to dashboard iff all values are valid
             * */

            if (app.isSessionValid()) {
                app.getRouter().navigate("/dashboard");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

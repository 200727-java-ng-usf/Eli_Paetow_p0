package com.revature.util;

import com.revature.models.AppUser;
import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;
import com.revature.repos.UserRepository;
import com.revature.screens.*;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {
    /*
     *these will help cut down on reduntant code
     * */

    private BufferedReader console;
    private AppUser currentUser;
    private ScreenRouter router;
    private boolean appRunning;
    private UserAccount currentAccount;

    public AppState() {

        /*
         *set app running
         * */

        appRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));

        final UserRepository userRepo = new UserRepository();
        final UserService userService = new UserService(userRepo);

        final AccountRepository accountRepository = new AccountRepository();
        final AccountService accountService = new AccountService(accountRepository);

        /*
         *set up the screen router
         * add all new screens here
         * */
        router = new ScreenRouter();
        router.addScreen(new LoginScreen(userService))
                .addScreen(new RegisterScreen(userService))
                .addScreen(new HomeScreen())
                .addScreen(new DashboardScreen())
                .addScreen(new DepositScreen(accountService))
                .addScreen(new WithdrawScreen(accountService))
                .addScreen(new BalanceViewScreen(accountService))
                .addScreen(new CreateNewAccountScreen(accountService));


    }

    /*
     *getters and setters
     * */
    public BufferedReader getConsole() {
        return console;
    }

    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }

    public ScreenRouter getRouter() {
        return router;
    }

    public UserAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(UserAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public boolean isAppRunning() {
        return appRunning;
    }


    public void setAppRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public void invalidateCurrentSession() {
        currentUser = null;
    }

    public boolean isSessionValid() {
        return (this.currentUser != null);
    }
}


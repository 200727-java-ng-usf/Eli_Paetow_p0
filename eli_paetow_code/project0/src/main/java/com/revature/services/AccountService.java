package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;

import java.io.IOException;
import java.text.NumberFormat;

import static com.revature.AppDriver.app;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepo) {

        accountRepository = accountRepo;
    }

    /*
     *authenticate users id before doin operations
     * */
    public void authenticate(Integer id) {

        // validate that the account is correct
        if (id == null || id.equals("")) {
            throw new InvalidRequestException("Invalid Id provided!");
        }
//        if (accountRepository.findById(id) != accountRepository.findById(id)) {
//            System.out.println("That is not your id");
//
//            app.setAppRunning(false);
//        }

        UserAccount authUserId = accountRepository.findById(id)
                .orElseThrow(AuthenticationException::new);


        app.setCurrentAccount(authUserId);

    }

    /*
     *if user is new and wants to crete a new account after registering
     * */

    public void createNewAccount(UserAccount newAccount) {
        if (!isAccountValid(newAccount)) {
            throw new InvalidRequestException("Invalid account");
        }
        accountRepository.save(newAccount);
        System.out.println("The new account has been saved");
        app.setCurrentAccount(newAccount);

    }


    /*
     *check to make sure the account has no null fields
     * */
    public boolean isAccountValid(UserAccount account) {
        if (account == null) return false;
        if (account.getBalance() == null) return false;
        if (account.getId() == null) return false;
        if (account.getUser_id() == null) return false;
        return true;
    }

    /*
     *if user wants to deposit. take balance and add the amout of deposit
     * update afterwards.
     * */
    public void depositAmount(UserAccount account, double deposit) {


        app.setCurrentAccount(app.getCurrentAccount());

        account.setBalance(account.getBalance() + deposit);
        System.out.println("Deposit complete!");
//        System.out.println(accountRepository);
        accountRepository.updateBalance(account.getBalance(), account.getId());
    }

    /*
     *if user wants to withdraw. check if amount is greater than balance
     * also check if it is a negative amount
     * if not simply take the balance and subtract the amount
     * then update afterwards.
     * */
    public void withdrawMethod(UserAccount account, Double amount) throws IOException {
        if (amount > account.getBalance()) {
            System.out.println("The amount is greater than your balance");
        } else if (amount < 0) {
            System.out.println("You can't withdraw a negative amount");

        } else {
            account.setBalance(account.getBalance() - amount);
            accountRepository.updateBalance(account.getBalance(), account.getId());
            System.out.println("Withdraw complete");
        }
    }

    /*
     *if user wants to view their balance
     * view balance
     * return to dashboard
     * */

    NumberFormat money = NumberFormat.getCurrencyInstance();

    public void viewBalance(UserAccount account) {

        app.setCurrentAccount(app.getCurrentAccount());
        accountRepository.updateBalance(account.getBalance(), account.getId());

        System.out.println(money.format(app.getCurrentAccount().getBalance()));
    }


}

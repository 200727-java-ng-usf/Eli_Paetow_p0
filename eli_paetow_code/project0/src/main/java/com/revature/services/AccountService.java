package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;

import static com.revature.AppDriver.app;

public class AccountService {

    private static AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepo){

        System.out.println("Account service is running");
        accountRepository = accountRepo;
    }
    public void authenticate(Integer id) {

        // validate that the account is correct
        if (id == null || id.equals("")) {
            throw new InvalidRequestException("Invalid Id provided!");
        }

        UserAccount authUserId = accountRepository.findById(id)
                .orElseThrow(AuthenticationException::new);

        app.setCurrentAccount(authUserId);

    }

    public void createNewAccount(UserAccount newAccount){
        if(!isAccountValid(newAccount)){
            throw new InvalidRequestException("Invalid account");
        }
        accountRepository.save(newAccount);
        System.out.println("The new account has been saved");
        app.setCurrentAccount(newAccount);

    }


    public boolean isAccountValid(UserAccount account){
        if (account == null) return false;
        if (account.getBalance() ==null) return false;
        if (account.getId() == null) return false;
        if(account.getUser_id() == null) return false;
        return true;
    }

    public void depositAmount(UserAccount account, double deposit){

        account.setBalance(account.getBalance() + deposit);
        System.out.println("Deposit complete!");
        accountRepository.updateBalance(account.getBalance(), account.getId());
    }


}

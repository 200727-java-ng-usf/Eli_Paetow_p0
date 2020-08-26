package com.revature.utils.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.models.UserAccount;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {


    private AccountService sut;

    private AccountRepository mockRepo = Mockito.mock(AccountRepository.class);

    Set<UserAccount> mockUserAccount = new HashSet<>();


    @Before
    public void setUp() {
        sut = new AccountService(mockRepo);
        mockUserAccount.add( new UserAccount(1, 100.0, 5));
        mockUserAccount.add( new UserAccount(2, 150.0, 5));
        mockUserAccount.add( new UserAccount(3, 190.0, 5));


    }

    @After
    public void tearDown() {
        sut = null;
        mockUserAccount.removeAll(mockUserAccount);
    }

    @Test
    public void authenticateValidCredentails(){

        UserAccount expectedAccount = new UserAccount(1, 100.0, 5);
        Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(expectedAccount));
    }

    @Test(expected = InvalidRequestException.class)
    public void authenticationWithInvalidCredentials() {

        sut.authenticate(null);

    }



}

package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.AppUser;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.revature.AppDriver.app;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        userRepo = repo;
    }


    /*
     *check if username and password are correct
     * not empty or full of spaces
     * */
    public void authenticate(String username, String password) {

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        AppUser authUser = userRepo.findUserByCredentials(username, password)
                .orElseThrow(AuthenticationException::new);

        app.setCurrentUser(authUser);

    }

    /*
     *check to see if all the fields are valid
     * */
    public boolean isUserValid(AppUser user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

    /*
     *if new user chooses to register
     * */
    public void register(AppUser newUser) {

        /*
         *check input to see if valid
         * */
        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user field values provided during registration!");
        }

        /*
         *check if user already exists
         * */
        Optional<AppUser> existingUser = userRepo.findUserByUsername(newUser.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Provided username is already in use!");
        }

        userRepo.save(newUser);

        app.setCurrentUser(newUser);

    }


}



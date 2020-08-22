package com.revature.repos;

import com.revature.models.AppUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {


    /*
     * show console that this class is running
     * */
    public UserRepository() {
        System.out.println("Running: " + this.getClass().getName());
    }

    /*
     * method to return an optional appuser. uses the connection factory to
     * talk to the DB and run SQL querys
     * */

    public Optional<AppUser> _user = Optional.empty();

    try(Connection conn = ConnectionFactory.getInstance().getConnection()){

    }catch(SQLException sqle){
        System.out.println("there was a SQL exception");
    }return _user;
}

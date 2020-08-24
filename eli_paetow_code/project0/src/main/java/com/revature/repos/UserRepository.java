package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public Optional<AppUser> findUserByCredentials(String username, String password) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM project0.app_users au " +
                                "JOIN project0.user_roles ur " +
                                "ON au.role_id = ur.id ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException sqle) {
            System.out.println("there was a SQL exception");
        }
        return _user;
    }


    /*
    * map results set
    *
    * */

    private Set<AppUser> mapResultSet(ResultSet rs) throws SQLException{
        Set<AppUser> users = new HashSet<>();

        /*
        * use the while loop to goo through and extract the results
        * */

        while (rs.next()){
            AppUser temp = new AppUser();
            temp.setId(rs.getInt("id"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLastName(rs.getString("last_name"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            System.out.println(temp);
            users.add(temp);
        }
        return  users;
    }


}




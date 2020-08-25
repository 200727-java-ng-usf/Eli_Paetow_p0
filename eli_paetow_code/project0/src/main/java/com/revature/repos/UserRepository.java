package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.models.Role;
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
    * empty constructor
     */
    public UserRepository() {

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
                    "ON au.role_id = ur.id " +
                    "WHERE username = ? AND password = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

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
            temp.setEmail(rs.getString("email"));
            temp.setRole(Role.getByName(rs.getString("name")));
            System.out.println(temp);
            users.add(temp);
        }
        return  users;
    }

    public Optional<AppUser> findUserByUsername(String username) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM project0.app_users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            _user = mapResultSet(rs).stream().findFirst();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return _user;

    }
    public void save(AppUser newUser) {


        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO project0.app_users (username, password, first_name, last_name, email, role_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            // second parameter here is used to indicate column names that will have generated values
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"id"});
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getFirstName());
            pstmt.setString(4, newUser.getLastName());
            pstmt.setString(5, newUser.getEmail());
            pstmt.setInt(6, newUser.getRole().ordinal() + 1);



            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                rs.next();
                newUser.setId(rs.getInt(1));

            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }


}}




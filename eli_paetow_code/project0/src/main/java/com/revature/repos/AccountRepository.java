package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.models.Role;
import com.revature.models.UserAccount;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.revature.AppDriver.app;

public class AccountRepository {

    /*
     * empty constructor
     * */
    public AccountRepository() {


    }

    /*
    * using an optional to allow the class to contain an
    * object or be empty
    * helps with functional programming
    * also provides great methods
    * */
    public Optional<UserAccount> findById(Integer id) {

        Optional<UserAccount> _account = Optional.empty();

        /*
         * try block to set up connection and find user by id
         * */

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            /*
             * query to be run inside of dbeaver
             * */
            String sql = "SELECT * FROM project0.app_users au " +
                    "JOIN project0.user_account ua " +
                    "ON au.role_id = ua.id " +
                    "WHERE ua.id = ? ";
//                    + app.getCurrentUser().getId();

            /*
             *prepare statemet and execute it
             * */
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            /*
             *map the result so ut can be returned
             * */
            _account = mapResultSet(rs).stream().findFirst();


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return _account;
    }

    /*
     * method for viewing the balance
     * */

    /*
     * currently not using this. but would like to in future improvements
     * */

    public Optional<UserAccount> findBalance(Integer id) {

        Optional<com.revature.models.UserAccount> _account = Optional.empty();



        /*
         * try block to set up connection and find user by id
         * */

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            /*
             * query to be run inside of dbeaver
             * */
            String sql = "SELECT balance FROM project0.user_account" +
                    "WHERE id = ? "
                 + id;

            /*
             *prepare statemet and execute it
             * */
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            /*
             *map the result so ut can be returned
             * */
            _account = mapResultSet(rs).stream().findFirst();


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return _account;
    }


    /*
     * method for saving the users balance and id
     * into the database
     * */
    public Optional<UserAccount> save(UserAccount account) {

        /*
         *try block to set up connection to save user
         * */
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            /*
             *sql query to be run in db
             * */

            String sql = "INSERT INTO project0.user_account (id , balance) VALUES (? , ?)";


            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});

            pstmt.setInt(1, account.getId());
            pstmt.setDouble(2, account.getBalance());

            int rowsInserted = pstmt.executeUpdate();

            /*
             *if statement to catch error if rows inserted is 0
             * */
            if (rowsInserted != 0) {

                ResultSet rs = pstmt.getGeneratedKeys();

                rs.next();
                account.setId(rs.getInt(1));

            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    /*
     * method to use after operations
     * sets results
     * */

    private Set<UserAccount> mapResultSet(ResultSet rs) throws SQLException {
        Set<UserAccount> accounts = new HashSet<>();

        /*
         * use the while loop to goo through and extract the results
         * */

        while (rs.next()) {
            UserAccount temp = new UserAccount();
            temp.setId(rs.getInt("id"));
            temp.setBalance(rs.getDouble("balance"));
            System.out.println(temp);
            accounts.add(temp);
        }
        return accounts;
    }

    /*
     *method to update the balance after user has withdrawn or deposited
     * */
    public Optional<UserAccount> updateBalance(Double balance, Integer id) {

//        Optional<UserAccount> _account = Optional.empty();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE project0.user_account SET balance = " + balance +
                    "WHERE id = " + id;

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


        return null;

    }
}

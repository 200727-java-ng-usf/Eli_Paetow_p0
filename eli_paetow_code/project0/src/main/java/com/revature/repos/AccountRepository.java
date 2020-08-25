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

    public AccountRepository() {
        System.out.println("Account repo is running");

    }

    public Optional<UserAccount> findById(Integer id) {

        Optional<UserAccount> _account = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM project0.app_users au " +
                    "JOIN project0.user_account ua " +
                    "ON au.role_id = ua.id " +
                    "WHERE ua.id = ? " + app.getCurrentUser().getId();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            _account = mapResultSet(rs).stream().findFirst();


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return _account;
    }

    public Optional<UserAccount> save(UserAccount account) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO project0.user_account (id , balance) VALUES (? , ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});

            pstmt.setInt(1, account.getId());
            pstmt.setDouble(2, account.getBalance());

            int rowsInserted = pstmt.executeUpdate();

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

    public static Optional<UserAccount> updateBalance(Double balance, Integer id) {

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

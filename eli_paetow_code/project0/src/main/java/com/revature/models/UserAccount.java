package com.revature.models;

import java.util.Objects;

public class UserAccount {
    /*
     * POJO for account
     * */
    private Integer id;
    private Double balance;
    private Integer user_id;


    /*
     * constructor for all fields
     * */
    public UserAccount(Integer id, Double balance, Integer user_id) {
        this.id = id;
        this.balance = balance;
        this.user_id = user_id;
    }

    /*
     * copy constructor to create a new instance with values
     * */
    public UserAccount(UserAccount copy){
        this(copy.id, copy.balance, copy.user_id);
    }

    /*
     * empty constructor
     * */

    public UserAccount() {

    }

    /*
     * getters and setters
     * */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /*
     * Overrides
     * */

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getBalance(), that.getBalance()) &&
                Objects.equals(getUser_id(), that.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getUser_id());
    }
}

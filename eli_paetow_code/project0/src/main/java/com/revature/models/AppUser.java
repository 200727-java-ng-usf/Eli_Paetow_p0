package com.revature.models;

import java.util.Objects;

public class AppUser {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer id;


    /*
     * constructor
     * */
    public AppUser(){
        super();
    }

    /*
    * constructor with everything
    * */
    public AppUser(String firstName, String lastName, String username, String password, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.id = id;
    }
    /*
     * constructor for new user
     * */
    public AppUser(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

    }

    /*
    * copy constructor
    * */
    // copy constructor (used for conveniently copying the values of one AppUser to create a new instance with those values)
    public AppUser(AppUser copy) {
        this(copy.firstName, copy.lastName, copy.username, copy.password, copy.id);
    }


    /*
     * getters and setters
     * */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
     * overides
     * */

    @Override
    public String toString() {
        return "AppUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getFirstName(), appUser.getFirstName()) &&
                Objects.equals(getLastName(), appUser.getLastName()) &&
                Objects.equals(getUsername(), appUser.getUsername()) &&
                Objects.equals(getPassword(), appUser.getPassword()) &&
                Objects.equals(getId(), appUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getUsername(), getPassword(), getId());
    }
}

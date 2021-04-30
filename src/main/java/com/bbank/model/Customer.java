package com.bbank.model;

public class Customer {
    private String name;
    private String username;
    private String password;
    private int accountID;

    public Customer() {

    }

    public Customer(String name, String username, String password, int accountID) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountID=" + accountID +
                '}';
    }
}


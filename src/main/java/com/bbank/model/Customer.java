package com.bbank.model;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private String username;
    private String password;
    private int accountID;
    private String account;
    private BigDecimal balance;

    public Customer() {

    }

    public Customer(String name, String username, String password, int accountID, String account, BigDecimal balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountID = accountID;
        this.account = account;
        this.balance = balance;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountID=" + accountID +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }
}


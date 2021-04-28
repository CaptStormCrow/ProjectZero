package com.bbank.model;

public class Accounts {
    private String typeOfAccount;
    private int amount;


    public Accounts(String typeOfAccount, int amount) {
        this.typeOfAccount = typeOfAccount;
        this.amount = amount;
    }

    public Accounts() {

    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "typeOfAccount='" + typeOfAccount + '\'' +
                ", amount=" + amount +
                '}';
    }
}

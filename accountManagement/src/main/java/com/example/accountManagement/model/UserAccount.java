package com.example.accountManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAccount {
    private final long id;

    private final long userId;

    private final double balance;


    public UserAccount(@JsonProperty("id")long id,
                       @JsonProperty("customer_id")long userId,
                       @JsonProperty("balance")double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }
}

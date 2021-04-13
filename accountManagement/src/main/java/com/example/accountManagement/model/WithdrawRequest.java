package com.example.accountManagement.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawRequest {
    @JsonCreator
    public WithdrawRequest(@JsonProperty("accountId") long accountId,
                           @JsonProperty("amount") double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    private long accountId;

    private double amount;

    public long getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }
}
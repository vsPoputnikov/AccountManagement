package com.example.accountManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation {
    private final long id;

    private final long accountId;

    private final String operationType;

    private final double amount;

    public Operation(
            @JsonProperty("id") long id,
            @JsonProperty("account_id") long accountId,
            @JsonProperty("type") String operationType,
            @JsonProperty("amount") double amount) {
        this.id = id;
        this.accountId = accountId;
        this.operationType = operationType;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", operationType='" + operationType + '\'' +
                ", amount=" + amount +
                '}';
    }
}

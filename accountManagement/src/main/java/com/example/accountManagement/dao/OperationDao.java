package com.example.accountManagement.dao;

import com.example.accountManagement.model.Operation;

import java.util.List;

public interface OperationDao {
    void addOperation(long accountId, double amount, String type);

    List<Operation> getUserAccountOperations(long accountId);
}

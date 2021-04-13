package com.example.accountManagement.dao;

import com.example.accountManagement.model.UserAccount;

import java.util.List;

public interface UserAccountDao {
    void addUserAccount(long userId);

    void deleteUserAccountByAccountId(long id);

    List<UserAccount> getUserAccounts(long userId);

    void deposit(long accountId, double amount);

    void withdraw(long accountId, double amount);

    double getUserAccountBalance(long accountId);

    double getUserBalance(long userId);
}

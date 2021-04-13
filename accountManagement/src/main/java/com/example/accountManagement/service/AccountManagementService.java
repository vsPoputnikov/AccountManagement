package com.example.accountManagement.service;

import com.example.accountManagement.dao.OperationDao;
import com.example.accountManagement.dao.UserAccountDao;
import com.example.accountManagement.dao.UserDao;
import com.example.accountManagement.model.Operation;
import com.example.accountManagement.model.OperationType;
import com.example.accountManagement.model.User;
import com.example.accountManagement.model.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountManagementService {
    private final UserDao userDao;
    private final UserAccountDao userAccountDao;
    private final OperationDao operationDao;

    public AccountManagementService(UserDao userDao, UserAccountDao userAccountDao, OperationDao operationDao) {
        this.userDao = userDao;
        this.userAccountDao = userAccountDao;
        this.operationDao = operationDao;
    }

    public void addUser(String fullName) {
        userDao.addUser(fullName);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteUser(long id) {
        userDao.deleteUserById(id);
    }

    public void addUserAccount(long userId) {
        userAccountDao.addUserAccount(userId);
    }

    public void deleteUserAccountByAccountId(long accountId) {
        userAccountDao.deleteUserAccountByAccountId(accountId);
    }

    public List<UserAccount> getAllUserAccounts(long userId) {
        return userAccountDao.getUserAccounts(userId);
    }

    public void deposit(long accountId, double amount) {
        userAccountDao.deposit(accountId, amount);
        operationDao.addOperation(accountId, amount, OperationType.DEPOSIT);
    }

    public void withdraw(long accountId, double amount) {
        userAccountDao.withdraw(accountId, amount);
        operationDao.addOperation(accountId, amount, OperationType.WITHDRAW);
    }

    public double getUserAccountBalance(long accountId) {
        return userAccountDao.getUserAccountBalance(accountId);
    }

    public double getUserBalance(long userId) {
        return userAccountDao.getUserBalance(userId);
    }

    public List<Operation> getUserAccountOperations(long accountId) {
        return operationDao.getUserAccountOperations(accountId);
    }
}

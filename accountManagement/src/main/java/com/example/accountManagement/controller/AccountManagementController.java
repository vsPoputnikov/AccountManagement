package com.example.accountManagement.controller;

import com.example.accountManagement.model.Operation;
import com.example.accountManagement.model.User;
import com.example.accountManagement.model.UserAccount;
import com.example.accountManagement.service.AccountManagementService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
public class AccountManagementController {

    private final AccountManagementService accountManagementService;

    public AccountManagementController(AccountManagementService accountManagementService) {
        this.accountManagementService = accountManagementService;
    }

    @GetMapping(path = "user/users")
    public List<User> getAllUsers() {
        return accountManagementService.getAllUsers();
    }

    @PostMapping(path = "user/add")
    public void addUser(@Valid @NonNull @RequestBody String fullName) {
        accountManagementService.addUser(fullName);
    }

    @PostMapping(path = "user/delete")
    public void deleteUser(@RequestBody long id) {
        accountManagementService.deleteUser(id);
    }

    @PostMapping(path = "account/add")
    public void addUserAccount(@RequestBody long userId) {
        accountManagementService.addUserAccount(userId);
    }

    @PostMapping(path = "account/delete")
    public void deleteUserAccount(@RequestBody long accountId) {
        accountManagementService.deleteUserAccountByAccountId(accountId);
    }

    @PostMapping(path = "account/byUser")
    public List<UserAccount> getUserAccounts(long userId) {
        return accountManagementService.getAllUserAccounts(userId);
    }

    @PostMapping(path = "account/withdraw")
    public void withdraw(@RequestBody long accountId, double amount) {
        accountManagementService.withdraw(accountId, amount);
    }

    @PostMapping(path = "account/deposit")
    public void deposit(@RequestBody long accountId, double amount) {
        accountManagementService.deposit(accountId, amount);
    }

    @PostMapping(path = "account/balance")
    public double getUserAccountBalance(@RequestBody long accountId) {
        return accountManagementService.getUserAccountBalance(accountId);
    }

    @PostMapping(path = "user/balance")
    public double getUserBalance(@RequestBody long userId) {
        return accountManagementService.getUserBalance(userId);
    }

    @PostMapping(path = "account/operations")
    public List<Operation> getUserAccountOperations(@RequestBody long accountId) {
        return accountManagementService.getUserAccountOperations(accountId);
    }
}

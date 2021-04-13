package com.example.accountManagement.controller;

import com.example.accountManagement.model.*;
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

    @PostMapping(path = "account/withdraw", consumes = "application/json", produces = "application/json")
    public void withdraw(@RequestBody WithdrawRequest request) {
        accountManagementService.withdraw(request.getAccountId(), request.getAmount());
    }

    @PostMapping(path = "account/deposit", consumes = "application/json", produces = "application/json")
    public void deposit(@RequestBody DepositRequest request) {
        accountManagementService.deposit(request.getAccountId(), request.getAmount());
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

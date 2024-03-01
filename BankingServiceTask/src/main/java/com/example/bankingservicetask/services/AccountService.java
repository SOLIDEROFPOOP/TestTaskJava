package com.example.bankingservicetask.services;

import com.example.bankingservicetask.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAllAccounts();

    public Optional<Account> getAccountById(Long accountId);

    public void transferMoney(Account senderAcc, Account receiverAcc, double amount);
}

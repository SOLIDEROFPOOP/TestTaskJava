package com.example.bankingservicetask.services.implementations;

import com.example.bankingservicetask.models.Account;
import com.example.bankingservicetask.repositories.AccountRepository;
import com.example.bankingservicetask.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public void transferMoney(Account senderAcc, Account receiverAcc, double amount) {
        if (senderAcc.getBalance() >= amount){
            senderAcc.setBalance(senderAcc.getBalance() - amount);
            receiverAcc.setBalance(receiverAcc.getBalance() + amount);
            accountRepository.save(senderAcc);
            accountRepository.save(receiverAcc);
        } else {
            throw new RuntimeException("Not enough balance in account");
        }
    }
}

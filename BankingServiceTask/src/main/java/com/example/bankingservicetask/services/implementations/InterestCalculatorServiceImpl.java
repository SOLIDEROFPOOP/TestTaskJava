package com.example.bankingservicetask.services.implementations;

import com.example.bankingservicetask.models.Account;
import com.example.bankingservicetask.repositories.AccountRepository;
import com.example.bankingservicetask.services.InterestCalculatorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestCalculatorServiceImpl implements InterestCalculatorService {
    private AccountRepository accountRepository;

    public InterestCalculatorServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void calculateInterest() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account: accounts){
            double interest = account.getBalance() * 0.05;
            double newBalance = account.getBalance() + interest;
            account.setBalance(Math.min(newBalance, account.getBalance() * 2.07));
            accountRepository.save(account);
        }
    }
}

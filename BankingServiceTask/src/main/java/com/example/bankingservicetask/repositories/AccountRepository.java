package com.example.bankingservicetask.repositories;

import com.example.bankingservicetask.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

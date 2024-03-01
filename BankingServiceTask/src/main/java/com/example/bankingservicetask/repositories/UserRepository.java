package com.example.bankingservicetask.repositories;

import com.example.bankingservicetask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

package com.example.bankingservicetask.services;

import com.example.bankingservicetask.models.Account;
import com.example.bankingservicetask.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getAllUsers();

    public Optional<User> getUserId(Long userId);

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUserById(Long userId);

    public Optional<Account> getUserAccount(Long userId);
}

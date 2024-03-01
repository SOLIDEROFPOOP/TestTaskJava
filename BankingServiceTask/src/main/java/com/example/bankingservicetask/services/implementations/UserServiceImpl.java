package com.example.bankingservicetask.services.implementations;

import com.example.bankingservicetask.models.Account;
import com.example.bankingservicetask.models.User;
import com.example.bankingservicetask.repositories.UserRepository;
import com.example.bankingservicetask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<Account> getUserAccount(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getAccount);
    }
}

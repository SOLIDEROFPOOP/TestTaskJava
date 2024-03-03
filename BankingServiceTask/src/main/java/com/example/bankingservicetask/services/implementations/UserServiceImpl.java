package com.example.bankingservicetask.services.implementations;

import com.example.bankingservicetask.dto.RegisterDTO;
import com.example.bankingservicetask.models.Account;
import com.example.bankingservicetask.models.User;
import com.example.bankingservicetask.repositories.AccountRepository;
import com.example.bankingservicetask.repositories.UserRepository;
import com.example.bankingservicetask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
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
    public User createUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setEmail(user.getEmail());
        Account account = new Account();
        account.setBalance(registerDTO.getBalanceAmount());
        user.setAccount(account);
        user.setPhoneNumber(registerDTO.getPhoneNumber());
        accountRepository.save(account);
        userRepository.save(user);
        return user;
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

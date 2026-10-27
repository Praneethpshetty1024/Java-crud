package com.example.crud.service;

import com.example.crud.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService{
User createUser(User user);
List<User> getAllUsers();
User updateUser(User user);
Optional<User> getUserById(Long id);
}
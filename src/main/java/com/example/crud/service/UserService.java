package com.example.crud.service;

import com.example.crud.model.User;
import java.util.List;

public interface UserService{
User createUser(User user);
List<User> getAllUsers();
User updateUser(User user);
}
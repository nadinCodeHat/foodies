package com.foodies.foodiesbackend.service;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.DTO.LoginDTO;
import com.foodies.foodiesbackend.DTO.UserDto;
import com.foodies.foodiesbackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User addUser(UserDto userDTO);

    ApiResponse login(LoginDTO loginDTO);

    Optional<User> getProfileData(int id);

    ApiResponse updateUser(int id, UserDto userDTO);

    int getAccountsCount();

    List<User> getAllUsers();

    List<User> getAllAdmins();

    ApiResponse deleteAccount(int userId);
}

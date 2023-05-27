package com.foodies.foodiesbackend.service;


import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowerService {
    List<User> getAllFollowers(int id);

    ApiResponse followUser(int id, int followUID);
}

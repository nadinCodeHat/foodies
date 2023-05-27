package com.foodies.foodiesbackend.service.impl;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.entity.User;
import com.foodies.foodiesbackend.repository.FollowerRepository;
import com.foodies.foodiesbackend.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public List<User> getAllFollowers(int uid) {
        List<User> users = followerRepository.findAllByTo_Id(uid);
        return users;
    }

    @Override
    public ApiResponse followUser(int uid, int followUID) {
        followerRepository.insertFollowUser(uid,followUID);
        return new ApiResponse(200, "User followed successfully", false);
    }
}

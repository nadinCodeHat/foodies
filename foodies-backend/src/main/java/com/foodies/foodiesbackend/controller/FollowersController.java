package com.foodies.foodiesbackend.controller;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.entity.User;
import com.foodies.foodiesbackend.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class FollowersController {

    @Autowired
    private FollowerService followerService;

    @GetMapping("/followers/{uid}")
    public List<User> getAllFollowers(@PathVariable int uid) {
        return followerService.getAllFollowers(uid);
    }

    @PostMapping( "/followers/{uid}/follow/{followUID}")
    public ApiResponse followUser(@PathVariable int uid, @PathVariable int followUID) {
        return followerService.followUser(uid, followUID);
    }
}

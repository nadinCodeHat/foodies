package com.foodies.foodiesbackend.service;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.DTO.PostDto;
import com.foodies.foodiesbackend.entity.Post;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PostService {
    ApiResponse savePost(int id, PostDto postDto) throws IOException;

    List<Post> getUserPosts(int id);

    List<Post> getAllPosts();

    ApiResponse deletePost(int postID);

    ApiResponse updatePost(int postId, PostDto postDto) throws IOException;

    ApiResponse addLikeUnlike(int postId, int userId);

    int getAllLikes(int postId);

    int getPostsCount();
}

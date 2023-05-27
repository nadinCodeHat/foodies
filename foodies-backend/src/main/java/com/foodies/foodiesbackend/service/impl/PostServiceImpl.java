package com.foodies.foodiesbackend.service.impl;


import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.DTO.PostDto;
import com.foodies.foodiesbackend.entity.Post;
import com.foodies.foodiesbackend.entity.User;
import com.foodies.foodiesbackend.repository.PostRepository;
import com.foodies.foodiesbackend.repository.UserRepository;
import com.foodies.foodiesbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResponse savePost(int id, PostDto postDto) throws IOException {
        Post post1 = new Post();

        //post1.findPostByUpk(id);
        User user = userRepository.findUserById(id);
        post1.setUser(user);
        post1.setPostDescription(postDto.getPostDescription());
        byte[] imageContent = postDto.getImage().getBytes();
        post1.setImage(imageContent);

        postRepository.save(post1);
        return new ApiResponse(200, "post added successfully", false);
    }

    @Override
    public List<Post> getUserPosts(int uid) {
        return postRepository.findAllByUser_Id(uid);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public ApiResponse deletePost(int postId) {
        Post post = postRepository.findPostById(postId);
        postRepository.delete(post);
        return new ApiResponse(200, "post deleted successfully", false);
    }

    @Override
    public ApiResponse updatePost(int postId, PostDto postDto) throws IOException {
        Post post = postRepository.findById(postId);
        if(post == null){
            return new ApiResponse(404, "Post does not exist", false);
        }else {
            Post updatePost = post;
            updatePost.setPostDescription(postDto.getPostDescription());
            byte[] imageContent = postDto.getImage().getBytes();
            updatePost.setImage(imageContent);
            postRepository.save(post);
            return new ApiResponse(200, "Post updated successfully", false);
        }
    }

    @Override
    public ApiResponse addLikeUnlike(int postId, int userId){
        int liked = postRepository.findByPostIdAndUserId(postId, userId);
        if(liked == 0){
            postRepository.addLike(postId, userId);
            return new ApiResponse(200, "Post liked successfully", false);
        }else {
            postRepository.deleteByPostIdAndUserId(postId, userId);
            return new ApiResponse(200, "Post unliked successfully", false);
        }
    }

    @Override
    public int getAllLikes(int postId){
        return postRepository.getAllLikes(postId);
    }

    @Override
    public int getPostsCount() {
        return (int) postRepository.count();
    }
}

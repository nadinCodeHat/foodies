package com.foodies.foodiesbackend.controller;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.DTO.PostDto;
import com.foodies.foodiesbackend.entity.Post;
import com.foodies.foodiesbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts/{id}")
    public ApiResponse savePost(@PathVariable int id, @ModelAttribute PostDto postDto) throws IOException {
        return postService.savePost(id, postDto);
    }

    @GetMapping( "/posts/{id}")
    public List<Post> getUserPosts(@PathVariable int id) {
        return postService.getUserPosts(id);
    }

    @GetMapping( "/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable int postId) {
        return postService.deletePost(postId);
    }

    @PatchMapping(value= "/post/{postId}")
    public ApiResponse updatePost(@PathVariable int postId,  @ModelAttribute PostDto postDto) throws IOException{
        return postService.updatePost(postId, postDto);
    }

    @PostMapping("/posts/{postId}/likes/{userId}")
    public ApiResponse addLikeUnlike(@PathVariable int postId, @PathVariable int userId) {
        return postService.addLikeUnlike(postId, userId);
    }

    @GetMapping("/posts/{postId}/likes")
    public int getAllLikes(@PathVariable int postId){
        return postService.getAllLikes(postId);
    }

    @GetMapping("/posts/count")
    public int getPostsCount() {
        return postService.getPostsCount();
    }
}

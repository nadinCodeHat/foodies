package com.foodies.foodiesbackend.service;

import com.foodies.foodiesbackend.DTO.ApiResponse;
import com.foodies.foodiesbackend.DTO.CommentDto;
import com.foodies.foodiesbackend.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

     Comment createComment(int postId, CommentDto comment);

     ApiResponse deleteComment(int commentId);

     ApiResponse updateComment(int commentId, CommentDto commentDto);
}

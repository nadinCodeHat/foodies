package com.foodies.foodiesbackend.repository;

import com.foodies.foodiesbackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//    @Query(value = "SELECT p.id, p.image, p.post_description, count(l.post_idadd) from post p inner join likes l on l.post_id = p.id where p.uid = :uid", nativeQuery = true)
    List<Post> findAllByUser_Id(int uid);

    Post findPostById(int id);

    void deleteByIdAndUserId(int id, int postId);

    Post findById(int postId);

    @Query(value = "select count(id) from likes where post_id = :postId and user_id = :userId", nativeQuery = true)
    int findByPostIdAndUserId(int postId, int userId);

    @Modifying
    @Transactional
    @Query(value = "insert into likes (post_id, user_id) values (:postId, :userId)", nativeQuery = true)
    void addLike(int postId, int userId);

    @Modifying
    @Transactional
    @Query(value = "delete from likes where post_id=:postId and user_id=:userId", nativeQuery = true)
    void deleteByPostIdAndUserId(int postId, int userId);

    @Query(value="select count(user_id) from likes where post_id=:postId", nativeQuery = true)
    int getAllLikes(int postId);
}

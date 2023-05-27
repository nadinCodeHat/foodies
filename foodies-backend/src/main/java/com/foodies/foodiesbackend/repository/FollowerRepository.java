package com.foodies.foodiesbackend.repository;

import com.foodies.foodiesbackend.entity.Followers;
import com.foodies.foodiesbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Followers, Integer> {
    @Query("SELECT " +
            "    new com.foodies.foodiesbackend.entity.User(u.id, u.firstName, u.lastName) " +
            "FROM " +
            "    user u " +
            "INNER JOIN " +
            "    followers f on u.id = f.from.id where f.from.id = :uid"
            )
    List<User> findAllByTo_Id(int uid);


//   @Query("INSERT INTO followers f (f.from.id, f.to.id) VALUES (:uid, :followID)")
    @Modifying
    @Transactional
    @Query(value = "insert into followers (from_user_fk, to_user_fk) values (:uid, :followUID)", nativeQuery = true)
    void insertFollowUser(int uid, int followUID);
}

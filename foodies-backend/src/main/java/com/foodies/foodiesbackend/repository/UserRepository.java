package com.foodies.foodiesbackend.repository;

import com.foodies.foodiesbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findUserById(int id);

    @Query(value = "select count(id) from user where user.role = 'user'", nativeQuery = true)
    int countAllByRole();

    List<User> findAllByRole(String role);
}

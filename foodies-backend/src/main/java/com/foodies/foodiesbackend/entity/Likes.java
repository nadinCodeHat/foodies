package com.foodies.foodiesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name= "likes")
@AllArgsConstructor
@Table(name = "likes")
@Getter
@Setter
public class Likes {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name="post_id")
    @JsonIgnore
    private Post post_id;

    @ManyToOne()
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user_id;

    public Likes() {};

    public Likes(Post post_id, User user_id) {
        this.post_id = post_id;
        this.user_id = user_id;
    }
}

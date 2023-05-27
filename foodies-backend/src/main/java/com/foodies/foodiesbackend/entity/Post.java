package com.foodies.foodiesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "post")
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "post_description", length = 255, nullable = true)
    private String postDescription;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    @JsonIgnore
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

    @JsonIgnore
    @OneToMany(mappedBy = "post_id")
    private List<Likes> likes;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postDescription='" + postDescription + '\'' +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }
}

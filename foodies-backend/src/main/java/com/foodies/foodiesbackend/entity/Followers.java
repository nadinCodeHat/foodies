package com.foodies.foodiesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name= "followers")
@AllArgsConstructor
@Table(name = "followers")
@Getter
@Setter
public class Followers {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="from_user_fk")
    @JsonIgnore
    private User from;

    @ManyToOne
    @JoinColumn(name="to_user_fk")
    @JsonIgnore
    private User to;

    public Followers() {};

    public Followers(User from, User to) {
        this.from = from;
        this.to = to;
    }

}

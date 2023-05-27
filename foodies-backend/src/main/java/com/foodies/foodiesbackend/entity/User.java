package com.foodies.foodiesbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity(name = "user")
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", length = 255, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    @Column(name = "age", length = 2, nullable = false)
    private int age;

    @Column(name = "gender", length = 255, nullable = false)
    private String gender;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @JsonIgnore
    private String password;

    @Column(name = "role")
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy="to")
    @JsonIgnore
    private List<Followers> followers;

    @OneToMany(mappedBy="from")
    @JsonIgnore
    private List<Followers> following;


    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
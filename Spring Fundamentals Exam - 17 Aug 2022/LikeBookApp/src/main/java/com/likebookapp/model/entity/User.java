package com.likebookapp.model.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    // @Column(nullable = false, unique = true)
    //    private String username;
    //
    //    @Column(nullable = false)
    //    private String password;
    //
    //    @Column(nullable = false, unique = true)
    //    private String email;
    //
    //    @OneToMany(mappedBy = "user")
    //    private Set<Post> posts;
    //
    //    @ManyToMany(mappedBy = "userLikes",fetch = FetchType.EAGER)
    //    private Set<Post> likedPosts;

    @Column(unique = true, nullable = false)
    public String username;

    @Column(nullable = false)
    public String password;

    @Column(unique = true, nullable = false)
    @Email
    public String email;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @ManyToMany(mappedBy = "userLikes", fetch = FetchType.EAGER)
    private List<Post> likedPosts;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public User setPosts(List<Post> posts) {
        this.posts = posts;
        return this;
    }

    public List<Post> getLikedPosts() {
        return likedPosts;
    }

    public User setLikedPosts(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
        return this;
    }
}

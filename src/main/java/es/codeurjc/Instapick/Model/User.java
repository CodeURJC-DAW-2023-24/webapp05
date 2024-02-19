package es.codeurjc.Instapick.Model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Blob avatar;
    private String userName;
    private String password;
    private Rol rol;
    @ManyToMany
    private List<User> friends;
    @OneToMany
    private Map<Long,Post> posts;
    @ManyToMany
    private List<Chat> chats;

    public Map<Long, Post> getPosts() {
        return posts;
    }

    public void setPosts(Map<Long, Post> posts) {
        this.posts = posts;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}

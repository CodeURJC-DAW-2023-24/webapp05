package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

@Entity
public class User {
    @Id
    private long id;
    private String userName; //nombre de cuenta del usuario
    private String password;
    private String name; //nombre real de usuario
    private String email;
    private Rol rol;
    private Blob avatar;


    public User() {

    }

    public User(String userName, String password, String name, String email) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    @ManyToMany
    private List<User> friends;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;
    @ManyToMany
    private List<Chat> chats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Rol getRol(){
        return rol;
    }

    public List<User> getFriends(){
        return friends;
    }

    public List<Post> getPosts(){
        return posts;
    }
    public String getPassword() {
        return password;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }



}
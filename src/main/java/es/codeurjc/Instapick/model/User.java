package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName; //nombre de cuenta del usuario
    @JsonIgnore
    private String encodedPassword;
    private String name; //nombre real de usuario
    private String description = "";
    private String email;
    private Rol rol;
    @Lob
    @JsonIgnore
    private Blob avatar;


    public User() {

    }

    public User(String userName, String password, String email, String name) {
        this.userName = userName;
        this.encodedPassword = password;
        this.name = name;
        this.email = email;
        this.description = "";
        this.posts = new ArrayList<>();
        this.rol = Rol.normal;
    }



    @ManyToMany
    @JsonIgnore
    private List<User> friends;
    @OneToMany(orphanRemoval = true ,cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnore
    private List<Post> posts;
    @ManyToMany
    @JsonIgnore
    private List<Chat> chats;

    public void addFriend(User friend){
        this.friends.add(friend);
    }

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
    public String getEncodedPassword() {
        return encodedPassword;
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

    public String getDescription() {
        return description;
    }

    public void setPassword(String password) {
        this.encodedPassword = password;
    }

    public void savePost(Post newPost) {
        this.posts.add(newPost);
    }
}
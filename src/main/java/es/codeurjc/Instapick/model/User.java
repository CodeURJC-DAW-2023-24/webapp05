package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // User ID
    private String userName; // User's username
    @JsonIgnore
    private String encodedPassword; // User's encrypted password
    private String name; // User's real name
    private String description = ""; // User's description
    private String email; // User's e-mail
    private Rol rol; // User's role account
    @Lob
    @JsonIgnore
    private Blob avatar; // User's avatar image
    @ManyToMany
    @JsonIgnore
    private List<User> friends; // User's friend list
    @OneToMany(orphanRemoval = true ,cascade = CascadeType.ALL, mappedBy = "author")
    @JsonIgnore
    private List<Post> posts; // User's posts (Linked to user)
    @ManyToMany
    @JsonIgnore
    private List<Chat> chats; // User's private chats (Linked to user)

    /* GETTERS - SETTERS */
        public User() {}

        public User(String userName, String password, String email, String name) {
            this.userName = userName;
            this.encodedPassword = password;
            this.name = name;
            this.email = email;
            this.description = "";
            this.posts = new ArrayList<>();
            this.rol = Rol.normal;
        }

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
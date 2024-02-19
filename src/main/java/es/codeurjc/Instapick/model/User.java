package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

@Entity
public class User {
    @Id
    private long id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private Rol rol;
    private Blob avatar;


    
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

}

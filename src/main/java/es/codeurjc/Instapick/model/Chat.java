package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat{
    @Id
    private long id;
    @ManyToMany
    private List<User> users;
    @OneToMany
    private List<Comment> comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

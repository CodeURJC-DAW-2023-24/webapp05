package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.List;

@Entity
public class Post {
    @Id
    private long id;

    private String description;
    private Blob multimedia;

    @ManyToOne
    private User author;
    @OneToMany
    private List<PostComment> comments;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
 }

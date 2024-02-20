package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Blob;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int likes; // cantidad de gente a la que le gusta
    private String description;

    @Lob
    @JsonIgnore
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

    public User getAuthor(){
        return author;
    }

    public List<PostComment> getComments(){
        return comments;
    }

    public int getLikes(){
        return likes;
    }

    public Post(){}

    public Post(String description, Blob multimedia) {
        this.description = description;
        this.multimedia = multimedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Blob multimedia) {
        this.multimedia = multimedia;
    }
}

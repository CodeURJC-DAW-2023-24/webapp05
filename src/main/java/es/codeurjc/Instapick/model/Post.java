package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView
    private long id; // Post ID
    @JsonView
    private int likes; // Likes amount
    @JsonView
    private String description; // Post description
    @Lob
    @JsonIgnore
    private Blob multimedia; // Post image
    @ManyToOne
    private User author; // Post author
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "fatherPost")
    @JsonIgnore
    private List<PostComment> comments; // Post comments list

    public void addLike() {
        this.likes++;
    }

    /* GETTERS - SETTERS */
        public Post() { 
        }

        public Post(String description, Blob multimedia, User author) {
            this.description = description;
            this.multimedia = multimedia;
            this.author = author;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
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

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        public List<PostComment> getComments() {
            return comments;
        }

        public void setComments(List<PostComment> comments) {
            this.comments = comments;
        }
}

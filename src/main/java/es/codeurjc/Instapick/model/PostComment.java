package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JsonIgnore
    private Post fatherPost;

    @ManyToOne
    @JsonView
    private User author;

    public PostComment(){}

    private String comment;// contenido de la clase

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public PostComment(Post fatherPost, User author, String comment) {
        this.fatherPost = fatherPost;
        this.author = author;
        this.comment = comment;
    }
}

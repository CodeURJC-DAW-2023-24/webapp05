package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; // Comment ID
    @ManyToOne
    @JsonIgnore
    private Post fatherPost; // Post related to comment
    @ManyToOne
    @JsonView
    private User author; // Comment author
    private String comment; // Comment's text

    /* GETTERS - SETTERS */
        public PostComment(){}

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

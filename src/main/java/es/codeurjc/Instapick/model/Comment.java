package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JsonIgnore
    private Chat chatFather;

    @ManyToOne
    @JsonView
    private User author;
    @JsonView
    private String comment; // Comment's text

    /* GETTERS - SETTERS */
        
        public Comment(Chat chatFather, User author, String comment){
            this.chatFather = chatFather;
            this.author = author;
            this.comment = comment;
        }

        public Comment() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getComment(){
            return comment;
        }
}

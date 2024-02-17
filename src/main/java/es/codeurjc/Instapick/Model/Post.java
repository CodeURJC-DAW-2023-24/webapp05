package es.codeurjc.Instapick.Model;

import javax.persistence.*;
import java.sql.Blob;

 @Entity
public class Post {
     @Id
     @GeneratedValue
    private long id;
    private String description;
    private Blob multimedia;
    @ManyToOne
    private User creator;
    @OneToMany
    private PostComment comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

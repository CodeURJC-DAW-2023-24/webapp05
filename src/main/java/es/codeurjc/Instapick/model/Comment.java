package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    private long id;
    @ManyToOne
    private Chat chatFather;

    private String comment;// contenido de la clase

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

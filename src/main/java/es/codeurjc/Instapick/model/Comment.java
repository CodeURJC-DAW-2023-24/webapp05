package es.codeurjc.Instapick.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    private long id;
    @ManyToOne
    private Chat chatFather;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

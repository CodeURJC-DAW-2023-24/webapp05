package es.codeurjc.Instapick.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class PostComment {

    @Id
    private long id;

    @ManyToOne
    private Post fatherPost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}

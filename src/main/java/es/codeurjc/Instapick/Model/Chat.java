package es.codeurjc.Instapick.Model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Chat{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private ArrayList<User> users;
    @OneToMany
    private ArrayList<Comment> coments;

    public ArrayList<Comment> getComents() {
        return coments;
    }

    public void setComents(ArrayList<Comment> coments) {
        this.coments = coments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}

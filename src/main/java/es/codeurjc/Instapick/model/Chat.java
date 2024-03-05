package es.codeurjc.Instapick.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
    @OneToMany
    @JsonView
    private List<Comment> comments;

    /* GETTERS - SETTERS */
        public Chat() {

        }

        public Chat(User user1, User user2) {
            this.user1 = user1;
            this.user2 = user2;
            this.comments = new ArrayList<>();
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public User getUser1() {
            return user1;
        }

        public void setUser1(User user1) {
            this.user1 = user1;
        }

        public User getUser2() {
            return user2;
        }

        public void setUser2(User user2) {
            this.user2 = user2;
        }

        public List<Comment> getComments(){
            return comments;
        }

        public void addChatMessage(Comment comm) {
            this.comments.add(comm);
        }
}

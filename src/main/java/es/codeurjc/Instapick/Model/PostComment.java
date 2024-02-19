package es.codeurjc.Instapick.Model;


import javax.persistence.ManyToOne;
import java.util.Date;

public class PostComment extends Comment{
    private long likes;
    @ManyToOne
    private Post fatherPost;

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public PostComment(User writer, String text, Date date) {
        super(writer, text, date);
    }
}

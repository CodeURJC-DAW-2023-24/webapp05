package es.codeurjc.Instapick.Model;


import javax.persistence.ManyToOne;

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
}

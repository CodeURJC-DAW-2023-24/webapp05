package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.Model.Post;
import es.codeurjc.Instapick.Model.PostComment;
import es.codeurjc.Instapick.repository.PostCommentRepository;
import es.codeurjc.Instapick.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {

    private PostCommentRepository postComments;

    public void save(PostComment post) {
        postComments.save(post);
    }

    public List<PostComment> findAll() {
        return postComments.findAll();
    }

    public Optional<PostComment> findById(Long id) {
        return postComments.findById(id);
    }

    public void replace(PostComment updatedPostComment) {
        postComments.findById(updatedPostComment.getId()).orElseThrow();

        postComments.save(updatedPostComment);
    }

    public void deleteById(Long id) {
        postComments.deleteById(id);
    }
}

package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Comment;
import es.codeurjc.Instapick.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository comnets;

    public void save(Comment comment) {
        comnets.save(comment);
    }

    public List<Comment> findAll() {
        return comnets.findAll();
    }

    public Optional<Comment> findById(Long id) {
        return comnets.findById(id);
    }

    public void replace(Comment updatedComment) {
        comnets.findById(updatedComment.getId()).orElseThrow();

        comnets.save(updatedComment);
    }

    public void deleteById(Long id) {
        comnets.deleteById(id);
    }
}

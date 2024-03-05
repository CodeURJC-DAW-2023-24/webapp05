package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.Comment;
import es.codeurjc.Instapick.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository comnets;

    public void save(Comment comment){ // Save chat comment
        comnets.save(comment);
    }

    public List<Comment> findAll(){ // Find all chat comments
        return comnets.findAll();
    }

    public Optional<Comment> findById(Long id){ // Find chat comment by ID
        return comnets.findById(id);
    }

    public void replace(Comment updatedComment){ // Replace/Update chat comment
        comnets.findById(updatedComment.getId()).orElseThrow();
        comnets.save(updatedComment);
    }

    public List<Comment> findByChatFather(Chat chat){ // Find chat comment by chat
        return comnets.findByChatFather(chat);
    }

    public void deleteById(Long id){ // Delete chat comment by ID
        comnets.deleteById(id);
    }
}

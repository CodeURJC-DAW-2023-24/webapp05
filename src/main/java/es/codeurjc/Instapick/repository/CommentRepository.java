package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByChatFather(Chat chatFather);

}

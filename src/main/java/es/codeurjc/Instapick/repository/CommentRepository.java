package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

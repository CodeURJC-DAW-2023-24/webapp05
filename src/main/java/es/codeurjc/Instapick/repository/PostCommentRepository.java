package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.Model.Post;
import es.codeurjc.Instapick.Model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}

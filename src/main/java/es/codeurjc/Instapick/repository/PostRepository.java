package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.Model.Comment;
import es.codeurjc.Instapick.Model.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

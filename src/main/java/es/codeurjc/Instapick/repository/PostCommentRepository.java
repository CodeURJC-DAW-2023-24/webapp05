package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    /* UNPAGINATED SEARCH QUERIES */
        List<Post> findByOrderByLikesDesc(); // Find most liked comments first
        List<Post> findByRecently(); // Find most recent comments first
    /* PAGINATED SEARCH QUERIES */
        Page<Post> findByOrderByLikesDesc(Pageable page); // Find most liked comments first
        Page<Post> findByRecently(Pageable page); // Find most recent comments first
}

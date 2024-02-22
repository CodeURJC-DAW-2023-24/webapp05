package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.PostComment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    /* UNPAGINATED SEARCH QUERIES */
        List<PostComment> findByOrderByLikesDesc(); // Find most liked comments first
        List<PostComment> findByRecently(); // Find most recent comments first
    /* PAGINATED SEARCH QUERIES */
        Page<PostComment> findAll(Pageable page); 
        Page<PostComment> findByOrderByLikesDesc(Pageable page); // Find most liked comments first
        Page<PostComment> findByRecently(Pageable page); // Find most recent comments first
}

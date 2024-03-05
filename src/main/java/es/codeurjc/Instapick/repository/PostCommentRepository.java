package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    @Query("select p from PostComment p where p.fatherPost = ?1")
    List<PostComment> getPostCommentOfPost(long fatherPost); // Get comments from post
    List<PostComment> findByFatherPost(Post fatherPost);
}

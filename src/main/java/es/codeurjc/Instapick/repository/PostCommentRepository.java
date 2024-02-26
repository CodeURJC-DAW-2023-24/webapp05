package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

    @Query("select p from PostComment p where p.fatherPost = ?1")
    List<PostComment> getPostCommentOfPost(long fatherPost);

    List<PostComment> findByFatherPost(Post fatherPost);

}

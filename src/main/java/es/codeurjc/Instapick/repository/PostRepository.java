package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    /* UNPAGINATED SEARCH QUERIES */
        List<Post> findByOrderByLikesDesc(); // Find posts by most liked first
        List<Post> findTop10ByLikes(); // Find top 10 comments based on likes
    /* PAGINATED SEARCH QUERIES */
        Page<Post> findAll(Pageable page); // Find all posts
        Page<Post> findByAuthor(String author, Pageable page); // Find posts by author name
        Page<Post> findFriendsFirst(String author, Pageable page); // Find friends posts
        Page<Post> findByOrderByLikesDesc(Pageable page); // Find posts by most liked first
}

package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    org.springframework.data.domain.Page<Post> findByAuthor(String author, Pageable page); // Find posts by author name
    org.springframework.data.domain.Page<Post> findAll(Pageable page); // Find all posts
    /* YET TO IMPLEMENT --> org.springframework.data.domain.Page<Post> findFriendsFirst(String author, Pageable page); */
    /* YET TO IMPLEMENT --> org.springframework.data.domain.Page<Post> findMostLiked(String author, Pageable page); */
}

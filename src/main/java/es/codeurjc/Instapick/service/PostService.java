package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository posts;

    public void save(Post post) {
        posts.save(post);
    }

    public List<Post> findAll() { // Unpaginated findAll
        return posts.findAll();
    }

    public Page<Post> findAll(PageRequest of) { // Paginated findAll
        return posts.findAll(of);
    }
    
    public List<Post> findBySort() {
        return posts.findByOrderByLikesDesc();
    }

    public Optional<Post> findById(Long id) {
        return posts.findById(id);
    }

    public void replace(Post updatedPost) {
        posts.findById(updatedPost.getId()).orElseThrow();
        posts.save(updatedPost);
    }

    public void deleteById(Long id) {
        posts.deleteById(id);
    }
}

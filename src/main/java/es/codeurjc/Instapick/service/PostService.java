package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.User;
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

    public void save(Post post){ // Save post
        posts.save(post);
    }

    public List<Post> findAll(){ // Find all posts
        return posts.findAll();
    }

    public Optional<Post> findById(Long id){ // Find post by ID
        return posts.findById(id);
    }

    public void replace(Post updatedPost){ // Replace post
        posts.findById(updatedPost.getId()).orElseThrow();
        posts.save(updatedPost);
    }

    public void deleteById(Long id){ // Delete post by ID
        posts.deleteById(id);
    }

    public List<Post> findBySort(){ // Sort posts by likes amount
        return posts.findByOrderByLikesDesc();
    }

    public Page<Post> findAll(PageRequest of){ // Find all posts (Paginated)
        return posts.findAll(of);
    }

    public List<Post> findByAuthor(User user){ // Find all posts by author
        return posts.findByAuthor(user);
    }

    public long count(){ // Find amount of posts
        return posts.count();
    }
}

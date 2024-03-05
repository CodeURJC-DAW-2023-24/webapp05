package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;
import es.codeurjc.Instapick.repository.PostCommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentRepository postComments;

    public void save(PostComment post){ // Save post comment
        postComments.save(post);
    }

    public List<PostComment> findAll(){ // Find all post comments
        return postComments.findAll();
    }

    public Optional<PostComment> findById(Long id){ // Find post comment by ID
        return postComments.findById(id);
    }

    public void replace(PostComment updatedPostComment){ // Replace post comment
        postComments.findById(updatedPostComment.getId()).orElseThrow();
        postComments.save(updatedPostComment);
    }

    public void deleteById(Long id){ // Delete post comment by ID
        postComments.deleteById(id);
    }

    public List<PostComment> getPostCommentOfPost(long id){ // Retrieve post comment list from post
        return postComments.getPostCommentOfPost(id);
    }

    public List<PostComment> findByFatherPost(Post fatherPost){ // Find post comment by post
        return postComments.findByFatherPost(fatherPost);
    }
}

package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.service.PostService;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.Instapick.model.PostComment;
import es.codeurjc.Instapick.service.PostCommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class PostCommentRestController {
    @Autowired
    private PostCommentService postComments;
    @Autowired
    private PostService posts;

    @GetMapping("/getCommentsOfPost")
    public List<PostComment> getPostsComments(@RequestParam long id){ // Retrieve posts' comments 
        List<PostComment> postCommentsOfFatherPost = postComments.findByFatherPost(posts.findById(id).get());
        return postCommentsOfFatherPost;
    }

}

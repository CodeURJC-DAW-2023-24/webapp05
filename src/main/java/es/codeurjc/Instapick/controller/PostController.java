package es.codeurjc.Instapick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.repository.PostRepository;
import es.codeurjc.Instapick.service.PostService;


@Controller
public class PostController {

    @Autowired
    private PostService posts;

    @GetMapping("/posts")
    public String getMethodName(){ // Main page, to implement
        
        return "post";
    }

    @GetMapping("/")
    public Page<Post> getPostsByAuthor(@RequestParam(required = false) String requesteduser, Pageable page){ // Search request to find posts by X author
        if (requesteduser != null){ // The user exists
            return posts.findByAuthor(requesteduser, page);
        } else{ // The user does not exist
            return posts.findAll(page);
        }
    }

    
}

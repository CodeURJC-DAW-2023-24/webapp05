package es.codeurjc.Instapick.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.repository.PostRepository;


@Controller
public class PostController {

    private PostRepository posts;

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

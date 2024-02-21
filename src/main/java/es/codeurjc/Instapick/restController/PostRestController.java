package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
public class PostRestController {

    @Autowired
    private PostService posts;

    @PutMapping("likeToPost/{id}")
    public boolean putMethodName(@PathVariable long id) {
        Optional<Post> selectedPost = posts.findById(id);
        selectedPost.get().addLike();
        return true;
    }

    @GetMapping("/getMorePosts")
    public Page<Post> getMorePosts(@RequestParam int from, @RequestParam int to) {
        Page<Post> postsToCharge = posts.findAll(PageRequest.of(from, to));
        return postsToCharge;
    }
}

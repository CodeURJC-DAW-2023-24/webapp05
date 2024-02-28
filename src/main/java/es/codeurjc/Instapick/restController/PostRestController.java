package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.PostCommentService;
import es.codeurjc.Instapick.service.PostService;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PostRestController {

    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;
    @Autowired
    private PostCommentService postComments;

    @GetMapping("/getMorePosts")
    public Page<Post> getMorePosts(@RequestParam int from, @RequestParam int to) {
        Page<Post> postsToCharge = posts.findAll(PageRequest.of(from, to));
        return postsToCharge;
    }


      @GetMapping("/get_CommentsOfPost")
      public java.util.List<PostComment> getMethodName(@RequestParam long id) {
          Optional<Post> postToGetComments = posts.findById(id);
          //return postToGetComments.get().getComments();
          return postComments.findByFatherPost(postToGetComments.get());
        }


    @PutMapping("likeToPost/{id}")
    public boolean likePost(@PathVariable long id) {
        Optional<Post> selectedPost = posts.findById(id);
        selectedPost.get().addLike();
        return true;
    }

    @PutMapping("/addFriend")
    public boolean addFriendToUser(@RequestParam long me, @RequestParam long who) {
        Optional<User> myUser = users.findById(me);
        Optional<User> friendToAdd = users.findById(who);
        if (myUser.isEmpty() || friendToAdd.isEmpty()) {
            return false;
        }
        myUser.get().addFriend(friendToAdd.get());
        users.save(myUser.get());
        return true;
    }

    @PutMapping("/sendCommenToPost")
    public PostComment putCommentToPost(@RequestParam long id, @RequestParam String text, HttpServletRequest request) {
        Optional<User> author = users.findByUserName(request.getUserPrincipal().getName());
        Optional<Post> postById = posts.findById(id);
        if (postById.isPresent()) {
            PostComment newPostComment = new PostComment(postById.get(), author.get(), text);
            postComments.save(newPostComment);
            return newPostComment;
        } else {
            return null;
        }
    }
}

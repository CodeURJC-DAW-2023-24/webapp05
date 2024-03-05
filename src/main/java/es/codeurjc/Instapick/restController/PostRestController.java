package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.PostComment;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.PostCommentService;
import es.codeurjc.Instapick.service.PostService;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostRestController {
    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;
    @Autowired
    private PostCommentService postComments;

    @GetMapping("/getMorePosts")
    public Page<Post> getMorePosts(@RequestParam int from, @RequestParam int to){ // Retrieve more posts
        Page<Post> postsToCharge = posts.findAll(PageRequest.of(from, to));
        return postsToCharge;
    }

    @GetMapping("/get_CommentsOfPost")
    public java.util.List<PostComment> getPostCommentsList(@RequestParam long id){ // Retrieve post's comment list
        Optional<Post> postToGetComments = posts.findById(id);
        return postComments.findByFatherPost(postToGetComments.get());
    }

    @GetMapping("/getAllPosts")
    public java.util.List<Post> getAllPosts(){ // Retrieve all posts
        List<Post> allPosts = posts.findAll();
        return allPosts;
    }

    @GetMapping("/getMyName")
    public String isOwner(HttpServletRequest request){ // Retrieve own user's real name
        String myName = request.getUserPrincipal().getName();
        return myName;
    }

    @GetMapping("/getProfilePost")
    public java.util.List<Post> getProfilePost(@RequestParam String name){ // Retrieve a profile's post list
        User user = users.findByUserName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        java.util.List<Post> allPost = posts.findByAuthor(user);
        return allPost;
    }

    @GetMapping("/getNumberOfPosts")
    public long getPostNumber(){ // Retrieve number of posts
        return posts.count();
    }

    @PutMapping("likeToPost/{id}")
    public boolean likePost(@PathVariable long id){ // Liking a post 
        Optional<Post> selectedPost = posts.findById(id);
        selectedPost.get().addLike();
        posts.save(selectedPost.get());
        return true;
    }

    @PutMapping("/addFriend")
    public boolean addFriendToUser(@RequestParam String frienName, HttpServletRequest request){ // Adding user to request sender as a friend
        Optional<User> myUser = users.findByUserName(request.getUserPrincipal().getName());
        Optional<User> friendToAdd = users.findByUserName(frienName);
        if (myUser.isEmpty() || friendToAdd.isEmpty()){ // Check users' existence
            return false;
        }
        myUser.get().addFriend(friendToAdd.get());
        users.save(myUser.get());
        return true;
    }

    @PutMapping("/sendCommenToPost")
    public PostComment putCommentToPost(@RequestParam long id, @RequestParam String text, HttpServletRequest request){ // Send comment to post
        Optional<User> author = users.findByUserName(request.getUserPrincipal().getName());
        Optional<Post> postById = posts.findById(id);
        if (postById.isPresent()){ // Check post's existence
            PostComment newPostComment = new PostComment(postById.get(), author.get(), text);
            postComments.save(newPostComment);
            return newPostComment;
        } else {
            return null;
        }
    }

}

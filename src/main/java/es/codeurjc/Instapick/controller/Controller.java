package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.Model.Post;
import es.codeurjc.Instapick.Model.PostComment;
import es.codeurjc.Instapick.repository.PostRepository;
import es.codeurjc.Instapick.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private PostService posts;

    @Autowired
    private ChatService chats;
    @Autowired
    private UserService users;

    private CommentService comments;

    private PostCommentService postComments;

    @GetMapping("/login")
    public String getLogIn(Model model) {
        return "log_in";
    }

    @GetMapping("/")
    public String getMain(Model model) {
        return "post";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        return "profile";
    }

    @GetMapping("/chats")
    public String getChats(Model model) {
        return "chat";
    }

    @GetMapping("/new_post")
    public String getNewPost(Model model) {
        return "new_post";
    }

    @PostMapping("/addNewPost")
    public void postMethodName(@RequestBody String entity) {
        System.out.println("Los datos són ::" + entity);
    }
}

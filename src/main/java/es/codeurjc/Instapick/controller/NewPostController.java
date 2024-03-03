package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.PostService;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NewPostController {

    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;

    @GetMapping("/newPost")
    public String getNewPost(Model model) {
        //model.addAttribute("token", );
        return "new_post";
    }

    private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    @PostMapping("/addNewPost")
    public String addNewPost(@RequestParam String description, @RequestParam MultipartFile image, Model model,
            HttpServletRequest request)
            throws IOException {
        Optional<User> author = users.findByUserName(request.getUserPrincipal().getName());
        Post newPost = new Post(description, BlobProxy.generateProxy(image.getInputStream(), image.getSize()),
                author.get());
        posts.save(newPost);
        String redirect = "redirect:/showSpecificPost/".concat(Long.toString(newPost.getId()));
        return redirect;
    }

    @GetMapping("/showSpecificPost/{id}")
    public String getMethodName(@PathVariable long id, Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }




        Optional<Post> postById = posts.findById(id);
        if (postById.isPresent()) {
            ArrayList<Post> postToShow = new ArrayList<>();
            postToShow.add(postById.get());
            model.addAttribute("postToShow", postToShow);
            return "post";
        } else {
            return "error";
        }
    }

}

package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.algorithms.SearchFriends;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.service.PostService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;

    private SearchFriends sfr = new SearchFriends();

    @GetMapping("/posts")
    public String getMethodName(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }
        if(request.getUserPrincipal() != null){
            List<Long> keys = sfr.doOperation(users.getFriendsOfUser(users.findByName(request.getUserPrincipal().getName()).get()));
            List<User> usersToAdd = new ArrayList<>();
            int sizeOfList = 4;
            if (sizeOfList > keys.size()){
                sizeOfList = keys.size();
            }
            for(int i = 0; i < sizeOfList; i++){
                usersToAdd.add(users.findById(keys.get(i)).get());
            }
            model.addAttribute("recommendedUsers", usersToAdd);
        }
        

        return "post";
    }

}
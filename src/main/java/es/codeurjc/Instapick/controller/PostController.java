package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.algorithms.SearchFriends;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private UserService users;

    private SearchFriends sfr = new SearchFriends();

    @GetMapping("/posts")
    public String getMethodName(Model model, HttpServletRequest request){ // Show main page for user
        Principal principal = request.getUserPrincipal();
        if(principal != null) { // Check logged status
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }
        if(request.getUserPrincipal() != null){ // Show friend suggestions if user is logged in as a non-guest
            List<Long> keys = sfr.doOperation(users.getFriendsOfUser(users.findByUserName(request.getUserPrincipal().getName()).get()));
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
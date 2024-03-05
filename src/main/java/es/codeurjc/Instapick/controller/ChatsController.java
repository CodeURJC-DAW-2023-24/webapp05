package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatsController {

    @Autowired
    private UserService users;

    @GetMapping("/chats")
    public String getMethodName(Model model, HttpServletRequest request){ // Check list of friends to show chat page

        Principal principal = request.getUserPrincipal();
        if(principal != null) { // Check logged status
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }


        Optional<User> userToGet = users.findByUserName(request.getUserPrincipal().getName());
        List<User> userFriends = users.getFriendsOfUser(userToGet.get());
        model.addAttribute("userName", request.getUserPrincipal().getName());
        model.addAttribute("chats", userFriends);
        return "chat";
    }

}

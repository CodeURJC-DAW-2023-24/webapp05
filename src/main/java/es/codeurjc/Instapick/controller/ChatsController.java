package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.service.ChatService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ChatsController {

    @Autowired
    private ChatService chats;
    @Autowired
    private UserService users;

    @GetMapping("/chats")
    public String getMethodName(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();
        if(principal != null) {
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

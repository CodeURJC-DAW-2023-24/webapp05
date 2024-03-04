package es.codeurjc.Instapick.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller

public class AdminController {

    @Autowired
    private UserService users;

    @GetMapping("/admin")
    public String getSignup(Model model, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }
        List<User> allUsers = users.getNotAdmin();
        model.addAttribute("usersToBan", allUsers);
        return "admin";
    }
}

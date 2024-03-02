package es.codeurjc.Instapick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;

@Controller

public class AdminController {

    @Autowired
    private UserService users;

    @GetMapping("/admin")
    public String getSignup(Model model) {
        List<User> allUsers = users.findAll();
        model.addAttribute("usersToBan", allUsers);
        return "admin";
    }
}

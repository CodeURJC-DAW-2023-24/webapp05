package es.codeurjc.Instapick.controller;


import es.codeurjc.Instapick.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import es.codeurjc.Instapick.model.*;

@Controller
public class SignupController {

    @Autowired
    private UserService users;

    @PostMapping("/addUser")
    public String createUser(@RequestParam String email, @RequestParam String name, @RequestParam String username,
     @RequestParam String password) {

        User user = new User(username, password, email, name);
        user.setRol(Rol.normal);

        users.addNewUser(user);

        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {

        return "signup";
    }
    
}

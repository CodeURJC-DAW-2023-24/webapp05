package es.codeurjc.Instapick.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class LoginController {

    @Autowired
    private UserService users;

    @GetMapping("/login")
    public String getSignup(Model model) {

        model.addAttribute("incorrect", false);

        return "log_in";
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletRequest request) {
        
        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }

        return "post";
    }
    
}

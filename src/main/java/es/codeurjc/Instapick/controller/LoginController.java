package es.codeurjc.Instapick.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    @GetMapping("/login")
    public String getSignup(Model model){ // Login redirection (Not signed up)
        model.addAttribute("incorrect", false);
        return "log_in";
    }

    @GetMapping("/")
    public String getLoginBar(Model model){ // Login redirection (General)
        return "log_in";
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletRequest request){ // Post redirection
        Principal principal = request.getUserPrincipal();
        if(principal != null) { // Check logged status
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }
        return "post";
    }
    
}

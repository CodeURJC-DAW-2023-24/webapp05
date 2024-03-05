package es.codeurjc.Instapick.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    UserService users;

    @GetMapping("/yourProfile")
    public String getOwnProfile(Model model, HttpServletRequest request){ // Show the user's (own) profile 
        Principal principal1 = request.getUserPrincipal();
        if(principal1 != null) { // Check logged status
            model.addAttribute("logged", true);
            User user = users.findByUserName(principal1.getName())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            model.addAttribute("userName",user.getUserName());
            model.addAttribute("name",user.getName());
            model.addAttribute("description",user.getDescription());
        } else {
            model.addAttribute("logged", false);
        }
        return "profile";
    }

    @GetMapping("/profile")
    public String getUserProfile(Model model, @RequestParam("name") String username, HttpServletRequest request) { // Show the user's profile (Not own)
            Principal principal = request.getUserPrincipal();
            if(principal != null) { // Check logged status
                model.addAttribute("logged", true);
            } else {
                model.addAttribute("logged", false);
            }

        User user = users.findByName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("name",user.getName());
        model.addAttribute("description",user.getDescription());
        return "profile";
    }






    
    
}

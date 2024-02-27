package es.codeurjc.Instapick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminController {
   
    @GetMapping("/admin")
    public String getSignup(Model model) {

        return "admin";
    } 
}

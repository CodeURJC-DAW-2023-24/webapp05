package es.codeurjc.Instapick.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class GraphicController {


    @GetMapping("/graph")
    public String getGraph(Model model, HttpServletRequest request){ // Create graphic showing statistics

        Principal principal = request.getUserPrincipal();
        if(principal != null) { // Check logged status
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }

        
        return "Graphic";
    }
    


}
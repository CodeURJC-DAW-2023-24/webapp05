package es.codeurjc.Instapick.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.Post;

// import com.itextpdf.kernel.pdf.PdfDocument;
// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.layout.Document;
// import com.itextpdf.layout.element.Paragraph;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    UserService users;

    @GetMapping("/yourProfile")
    public String getMethodName(Model model, Principal principal, HttpServletRequest request) {

        Principal principal1 = request.getUserPrincipal();
        if(principal1 != null) {
            model.addAttribute("logged", true);
        } else {
            model.addAttribute("logged", false);
        }

        User user = users.findByUserName(principal.getName())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        model.addAttribute("userName",user.getUserName());
        model.addAttribute("name",user.getName());
        model.addAttribute("description",user.getDescription());


        return "profile";
    }

    @GetMapping("/profile")
    public String getMethodName(Model model, @RequestParam("name") String username, HttpServletRequest request) {

            Principal principal = request.getUserPrincipal();
            if(principal != null) {
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

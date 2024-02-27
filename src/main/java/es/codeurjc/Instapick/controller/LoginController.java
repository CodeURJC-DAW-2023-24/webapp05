package es.codeurjc.Instapick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller

public class LoginController {

    @Autowired
    private UserService users;

    @RequestMapping("/login")
    public String getSignup(Model model) {

        model.addAttribute("incorrect", false);

        return "log_in";
    }

    // @PostMapping("/login")
    // public String loginUser(@RequestParam String username,
    //  @RequestParam String password, HttpSession session, Model model) {
        
    //     User user = users.findByUserName(username);
    //     if (user == null || !password.equals(user.getPassword())) {
    //         model.addAttribute("incorrect", true);
    //         return "log_in";
    //     }else if (password.equals(user.getPassword())){
            
    //         session.setAttribute("userName", user.getUserName());
    //         session.setAttribute("name", user.getName());
    //         session.setAttribute("password", user.getPassword());
    //         session.setAttribute("email", user.getEmail());
    //         session.setAttribute("rol", user.getRol());
    //         session.setAttribute("avatar", user.getAvatar());
    //         session.setAttribute("id", user.getId());

    //         return "redirect:/posts";

    //     }

    //     model.addAttribute("incorrect", true);

    //     return "log_in";
    // }
    
}

package es.codeurjc.Instapick;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/login")
    public String getLogIn(Model model) {
        return "log_in";
    }

    @GetMapping("/")
    public String getMain(Model model) {
        return "post";
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        return "profile";
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        return "signup";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        return "admin";
    }

    @GetMapping("/newpost")
    public String getNewPost(Model model) {
        return "new_post";
    }
    
    @GetMapping("/profile")
    public String getProfile(Model model) {
        return "profile";
    }
    
    @GetMapping("/grafic")
    public String getGrafic(Model model) {
        return "Grafic";
    }

    @GetMapping("/chat")
    public String getChat(Model model) {
        return "chat";
    }
    
}

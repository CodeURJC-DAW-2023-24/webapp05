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

}

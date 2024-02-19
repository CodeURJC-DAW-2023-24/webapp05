package es.codeurjc.Instapick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getMethodName() {
        return "post";
    }

}

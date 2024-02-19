package es.codeurjc.Instapick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatsController {
    @GetMapping("/chats")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

}

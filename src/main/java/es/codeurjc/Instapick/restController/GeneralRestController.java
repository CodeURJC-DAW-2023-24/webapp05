package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralRestController {

    @Autowired
    private UserService users;

    @GetMapping("/getUserForSearch")
    public List<User> getUsersBySearch(@RequestParam String name){
        List<User> usersSearch = users.getSearchedUsers(name);
        return usersSearch;
    }

}

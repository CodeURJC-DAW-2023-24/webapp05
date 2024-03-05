package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GeneralRestController {
    @Autowired
    private UserService users;

    @GetMapping("/getUserForSearch")
    public List<User> getUsersBySearch(@RequestParam String name){ // Retrieve users in search function
        List<User> usersSearch = users.getSearchedUsers(name);
        return usersSearch;
    }

    @DeleteMapping("/banUser")
    public boolean deleteUser(@RequestParam long id){ // Ban user from platform
        users.deleteById(id);
        Optional<User> userToDelete = users.findById(id);
        if (userToDelete.isPresent()){ // Check user's existence
            return false;
        }
        return true;
    }

}

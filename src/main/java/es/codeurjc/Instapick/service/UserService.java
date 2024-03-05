package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository users;

    public void save(User user){ // Save user
        users.save(user);
    }

    public List<User> findAll(){ // Find all users
        return users.findAll();
    }

    public Optional<User> findById(Long id){ // Find user by ID
        return users.findById(id);
    }

    public void replace(User updatedPost){ // Replace user
        users.findById(updatedPost.getId()).orElseThrow();
        users.save(updatedPost);
    }

    public void deleteById(Long id){ // Delete user by ID
        users.deleteById(id);
    }

    public Optional<User> findByUserName(String userName){ // Find user by its username
        return users.findByUserName(userName);
    }

    public void addNewUser(User user){ // Add new user
        users.save(user);
    }

    public List<User> getFriendsOfUser(User user){ // Retrieve user's friends
        return users.getFriendsOfUser(user);
    }

    public List<User> getSearchedUsers(String name){ // Retrieve users in search function
        return users.getSearchedUsers(name);
    }

    public Optional<User> findByName(String name){ // Find user by real name
        return users.findByName(name);
    }

    public  List<User> getNotAdmin(){ // Retrieve all non-admin users
        return users.getNotAdmin();
    }
}

package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository users;

    public void save(User user) {
        users.save(user);
    }

    public List<User> findAll() {
        return users.findAll();
    }

    public Optional<User> findById(Long id) {
        return users.findById(id);
    }

    public void replace(User updatedPost) {
        users.findById(updatedPost.getId()).orElseThrow();

        users.save(updatedPost);
    }

    public void deleteById(Long id) {
        users.deleteById(id);
    }

    public Optional<User> findByUserName(String userName) {
        return users.findByUserName(userName);
    }
}

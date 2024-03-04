package es.codeurjc.Instapick.security;

import es.codeurjc.Instapick.model.Rol;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.Optional;

@Component
public class DataBaseUserLoader {

    @Value("${security.user}")
    private String username;

    @Value("${security.password}")
    private String encodedPassword;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDatabase() {
        Optional<User> existsAdmin = userRepository.findByUserName(username);
        if(existsAdmin.isEmpty()){
            User adminUser = new User(username, encodedPassword, "", "");
            adminUser.setRol(Rol.admin);
            userRepository.save(adminUser);
        }
    }
}

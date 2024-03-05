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
    private void initDatabase(){ // Initializing database 
        Optional<User> existsAdmin = userRepository.findByUserName(username);
        if(existsAdmin.isEmpty()){
            User adminUser = new User(username, encodedPassword, "", "");
            adminUser.setRol(Rol.admin);
            userRepository.save(adminUser);

            Optional<User> existsUser = userRepository.findByUserName("Antonio");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Antonio", passwordEncoder.encode("choco"), "antoniochoco@gmail.com", "Anton"));
            existsUser = userRepository.findByUserName("Fernando");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Fernando", passwordEncoder.encode("late"), "fernandolate@gmail.com", "Ferxxo"));
            existsUser = userRepository.findByUserName("Juana");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Juana", passwordEncoder.encode("cafe"), "juanacafe@gmail.com", "Juanilla"));
            existsUser = userRepository.findByUserName("La Hermana");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("La Hermana", passwordEncoder.encode("cappucino"), "hermanacappucino@gmail.com", "Sister"));
            existsUser = userRepository.findByUserName("Pepa");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Pepa", passwordEncoder.encode("expresso"), "pepaexpresso@gmail.com", "Pepita"));
            existsUser = userRepository.findByUserName("Marcos");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Marcos", passwordEncoder.encode("caffe latte"), "marcoscaffe.latte@gmail.com", "Marquitos"));
            existsUser = userRepository.findByUserName("Pepe");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Pepe", passwordEncoder.encode("americano"), "pepeamericano@gmail.com", "Pepon"));
            existsUser = userRepository.findByUserName("Paco");
            if(existsAdmin.isEmpty()) // Check user's existence
                userRepository.save(new User("Paco", passwordEncoder.encode("macchiato"), "pacomacchiato@gmail.com", "Pacope"));
        }
    }
}

package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUserName(String userName);
}

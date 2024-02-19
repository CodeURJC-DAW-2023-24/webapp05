package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.Model.Comment;
import es.codeurjc.Instapick.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUserName(String userName);

    @Query("select distinct a from User b join b.friends a where b = ?1")
    public List<User> getFriendsOfUser(User user);
}

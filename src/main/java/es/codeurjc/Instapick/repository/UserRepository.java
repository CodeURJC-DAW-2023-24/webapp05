package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUserName(String userName); // Find user by their username
    @Query("select distinct a from User b join b.friends a where b = ?1")
    public List<User> getFriendsOfUser(User user); // Retrieve user's friends
    @Query("select a from User a where a.name like %?1%")
    public List<User> getSearchedUsers(String name); // Retrieve searched users
    public Optional<User> findByName(String name); // Find user by real name
    @Query("SELECT u FROM User u WHERE u.rol = 0")
    public List<User> getNotAdmin(); // Retrieve by non-admin user
}

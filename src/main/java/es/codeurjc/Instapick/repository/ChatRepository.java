package es.codeurjc.Instapick.repository;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ChatRepository extends JpaRepository<Chat, Long>{
    @Query("select distinct c from Chat c where c.user1 = ?1 and c.user2 = ?2")
    Optional<Chat> getChatOfFriends(User u1, User u2); // Get 2 user's chats 

}

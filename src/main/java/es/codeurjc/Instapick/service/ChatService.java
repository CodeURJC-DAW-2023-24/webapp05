package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.repository.ChatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chats;

    public void save(Chat chat) {
        chats.save(chat);
    }

    public List<Chat> findAll() {
        return chats.findAll();
    }

    public Optional<Chat> findById(Long id) {
        return chats.findById(id);
    }

    public void replace(Chat updatedChat) {
        chats.findById(updatedChat.getId()).orElseThrow();

        chats.save(updatedChat);
    }

    public void deleteById(Long id) {
        chats.deleteById(id);
    }

    public Optional<Chat> getChatOfFriends(User u1, User u2){
        return chats.getChatOfFriends(u1,u2);
    }

}

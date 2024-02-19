package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.Model.Chat;
import es.codeurjc.Instapick.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private ChatService chats;

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

}

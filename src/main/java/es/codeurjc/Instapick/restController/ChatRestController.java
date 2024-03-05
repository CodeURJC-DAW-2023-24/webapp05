package es.codeurjc.Instapick.restController;

import es.codeurjc.Instapick.model.Chat;
import es.codeurjc.Instapick.model.Comment;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.ChatService;
import es.codeurjc.Instapick.service.CommentService;
import es.codeurjc.Instapick.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChatRestController {
    @Autowired
    private UserService users;
    @Autowired
    private ChatService chats;
    @Autowired
    private CommentService comments;

    @GetMapping("getChat/{userName}")
    public List<Comment> getMasaggesOfChat(@PathVariable String userName, HttpServletRequest request){ // Retrieve messages from private chat
        User me = users.findByUserName(request.getUserPrincipal().getName()).get();
        User friend = users.findByName(userName).get();
        Optional<Chat> chatToSearch = chats.getChatOfFriends(me, friend);
        if (chatToSearch.isEmpty()){ // Check if chat exists
            Chat newChat = new Chat(me, friend);
            chats.save(newChat);
            return newChat.getComments();
        }
        return comments.findByChatFather(chatToSearch.get());
    }

    @PutMapping("/addFriend/{name}")
    public boolean addFriend(@PathVariable String name, HttpServletRequest request){ // Add friend
        Optional<User> me = users.findByUserName(request.getUserPrincipal().getName());
        Optional<User> friend = users.findByUserName(name);
        if (me.isEmpty() || friend.isEmpty()) { // Check users' existence
            return false;
        }
        me.get().addFriend(friend.get());
        users.save(me.get());
        return true;
    }

    @PutMapping("/sendChatMessage/{friend}")
    public boolean addChatMessage(@PathVariable String friend, @RequestParam String txt, HttpServletRequest request){ // Send message to specific chat
        User me = users.findByUserName(request.getUserPrincipal().getName()).get();
        User friendToSearch = users.findByName(friend).get();
        Optional<Chat> chatToSearch = chats.getChatOfFriends(me, friendToSearch);
        Comment comm = new Comment(chatToSearch.get(), me, txt);
        comments.save(comm);
        return true;
    }

}

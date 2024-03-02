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
    public List<Comment> getMasaggesOfChat(@PathVariable String userName, HttpServletRequest request){
        User me = users.findByUserName(request.getUserPrincipal().getName()).get();
        User friend = users.findByUserName(userName).get();
        Optional<Chat> chatToSearch = chats.getChatOfFriends(me, friend);
        if (chatToSearch.isEmpty()){
            Chat newChat = new Chat(me, friend);
            chats.save(newChat);
            return newChat.getComments();
        }
        //return chatToSearch.get().getComments();
        List<Comment> commentsToSend = comments.findByChatFather(chatToSearch.get());
        return comments.findByChatFather(chatToSearch.get());
    }

    @PutMapping("/addFriend/{name}")
    public boolean addFriend(@PathVariable String name, HttpServletRequest request){
        String nameMe = request.getUserPrincipal().getName();
        Optional<User> me = users.findByUserName(request.getUserPrincipal().getName());
        Optional<User> friend = users.findByUserName(name);
        if (me.isEmpty() || friend.isEmpty()){
            return false;
        }
        me.get().addFriend(friend.get());
        users.save(me.get());
        return true;
    }

    @PutMapping("/sendChatMessage/{friend}")
    public boolean addChatMessage(@PathVariable String friend, @RequestParam String txt, HttpServletRequest request){
        User me = users.findByUserName(request.getUserPrincipal().getName()).get();
        User friendToSearch = users.findByUserName(friend).get();
        Optional<Chat> chatToSearch = chats.getChatOfFriends(me, friendToSearch);
        Comment comm = new Comment(chatToSearch.get(), me, txt);
        comments.save(comm);
        //chatToSearch.get().addChatMessage(comm);
        //chats.save(chatToSearch.get());
        return true;
    }

}
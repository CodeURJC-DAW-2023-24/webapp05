package es.codeurjc.Instapick.controller;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.model.User;
import es.codeurjc.Instapick.service.PostService;
import es.codeurjc.Instapick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.Optional;

@Controller
public class MediaController {
    @Autowired
    private PostService posts;
    @Autowired
    private UserService users;

    @GetMapping("/imagePost/{id}")
    public ResponseEntity<Object> downloadImagePost(@PathVariable long id) throws SQLException{ // Retrieve the image from a specific post
        Optional<Post> searchedPost = posts.findById(id);
        if(searchedPost.isPresent()){ // Check post existence
            if (searchedPost.get().getMultimedia() != null){ // Check image existence 
                org.springframework.core.io.Resource file =  new InputStreamResource(searchedPost.get().getMultimedia().getBinaryStream()); // Image's binary stream recollection
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, "image/jpg")
                        .contentLength(searchedPost.get().getMultimedia().length())
                        .body(file);

            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/imageUser/{id}")
    public ResponseEntity<Object> dowloadImageUser(@PathVariable long id) throws SQLException{ // Retrieve the user from a specific post
        Optional<User> userToGet = users.findById(id);
        if(userToGet.isPresent()){ // Check user existence
            if (userToGet.get().getAvatar() != null){ // Check avatar image existence
                org.springframework.core.io.Resource file =  new InputStreamResource(userToGet.get().getAvatar().getBinaryStream()); // Image's binary stream recollection
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, "image/jpg")
                        .contentLength(userToGet.get().getAvatar().length())
                        .body(file);

            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}

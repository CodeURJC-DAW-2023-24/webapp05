package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.Post;
import es.codeurjc.Instapick.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository posts;

    public void save(Post post) {
        posts.save(post);
    }

    /* UNPAGINATED QUERY FUNCTIONS */
        public List<Post> findAll() {
            return posts.findAll();
        }
        public List<Post> findBySort() {
            return posts.findByOrderByLikesDesc();
        }
        public List<Post> findTop10Liked() {
            return posts.findTop10ByLikes();
        }
    /* PAGINATED QUERY FUNCTIONS */
        public Page<Post> findAll(PageRequest of) {
            return posts.findAll(of);
        }
        public Page<Post> findBySort(PageRequest of) {
            return posts.findByOrderByLikesDesc(of);
        }
        public Page<Post> findByFriends(String friend, PageRequest of) {
            return posts.findFriendsFirst(friend, of);
        }
        public Page<Post> findByAuthor(String author, PageRequest of) {
            return posts.findFriendsFirst(author, of);
        }

    public Optional<Post> findById(Long id) {
        return posts.findById(id);
    }

    public void replace(Post updatedPost) {
        posts.findById(updatedPost.getId()).orElseThrow();
        posts.save(updatedPost);
    }

    public void deleteById(Long id) {
        posts.deleteById(id);
    }
}

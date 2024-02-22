package es.codeurjc.Instapick.service;

import es.codeurjc.Instapick.model.PostComment;
import es.codeurjc.Instapick.repository.PostCommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {

    private PostCommentRepository postComments;

    public void save(PostComment post) {
        postComments.save(post);
    }

    /* UNPAGINATED SEARCH QUERY FUNCTIONS */
        public List<PostComment> findAll() {
            return postComments.findAll();
        }
        public List<PostComment> findBySort() {
            return postComments.findByOrderByLikesDesc();
        }
        public List<PostComment> findByRecent() {
            return postComments.findByRecently();
        }
    /* PAGINATED SEARCH QUERY FUNCTIONS */
        public Page<PostComment> findAll(PageRequest of) {
            return postComments.findAll(of);
        }
        public Page<PostComment> findBySort(PageRequest of) {
            return postComments.findByOrderByLikesDesc(of);
        }
        public Page<PostComment> findByRecent(PageRequest of) {
            return postComments.findByRecently(of);
        }

    public Optional<PostComment> findById(Long id) {
        return postComments.findById(id);
    }

    public void replace(PostComment updatedPostComment) {
        postComments.findById(updatedPostComment.getId()).orElseThrow();

        postComments.save(updatedPostComment);
    }

    public void deleteById(Long id) {
        postComments.deleteById(id);
    }
}

package com.technews.controller;

import com.technews.model.Post;
import com.technews.model.Vote;
import com.technews.model.User;
import com.technews.repository.PostRepository;
import com.technews.repository.UserRepository;
import com.technews.repository.VoteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostRepository repository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        List<Post> postList = repository.findAll();
        for (Post p : postList) {
            p.setVoteCount(voteRepository.countVotesByPostId(p.getId()));
        }
        return postList;
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable Integer id) {
        Optional<Post> optionalPost = repository.findById(id);
        Post returnPost = optionalPost.orElseThrow(() -> new EntityNotFoundException("Post not found"));
        returnPost.setVoteCount(voteRepository.countVotesByPostId(returnPost.getId()));

        return returnPost;
    }

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post){
        repository.save(post);
        return post;
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post post){
        Optional<Post> optionalPost = repository.findById(id);
        Post tempPost = optionalPost.orElseThrow(() -> new EntityNotFoundException("Post not found"));
        tempPost.setTitle(post.getTitle());
        return repository.save(tempPost);
    }

    @PutMapping("/api/posts/upvote")
    public String addVote(@RequestBody Vote vote, HttpServletRequest request){
        String returnValue = "";

        if (request.getSession(false) != null) {
            User sessionUser = (User) request.getSession().getAttribute("SESSION_USER");
            vote.setUserId(sessionUser.getId());
            voteRepository.save(vote);

            Optional<Post> optionalPost = repository.findById(vote.getPostId());
            optionalPost.ifPresent(returnPost ->
                    returnPost.setVoteCount(voteRepository.countVotesByPostId(returnPost.getId()))
            );
        } else {
            returnValue = "login";
        }

        return returnValue;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id){
        repository.deleteById(id);
    }
}

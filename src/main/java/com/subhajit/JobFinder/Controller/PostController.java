package com.subhajit.JobFinder.Controller;

import com.subhajit.JobFinder.Model.Post;
import com.subhajit.JobFinder.Repository.PostRepository;
import com.subhajit.JobFinder.Repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PostController {
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepo seRepo;
    @GetMapping("/getPosts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
    @GetMapping("/getPost/{text}")
    public  List<Post> search(@PathVariable String text)
    {
        return  seRepo.searchByText(text);
    }

    @GetMapping("/getPostByProfile")
    public  List<Post> searchByProfile(@RequestParam String profile){
        return repo.findByProfile(profile);
    }
}

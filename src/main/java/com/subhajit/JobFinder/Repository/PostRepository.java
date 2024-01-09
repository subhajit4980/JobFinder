package com.subhajit.JobFinder.Repository;

import com.subhajit.JobFinder.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String>
{
    List<Post> findByProfile(String profile);
}

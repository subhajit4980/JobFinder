package com.subhajit.JobFinder.Repository;

import com.subhajit.JobFinder.Model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
public interface SearchRepo {
    List<Post> searchByText(String text);
}

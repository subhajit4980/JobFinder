package com.subhajit.JobFinder.Repository;

import com.mongodb.client.*;
import com.subhajit.JobFinder.Model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImp implements SearchRepo {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> searchByText(String text) {
        final List<Post> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("JobFinder");
        MongoCollection<Document> collection = database.getCollection("Jobpost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", text).append("path", Arrays.asList("techs", "description", "profile")))),
                new Document("$sort", new Document("exp", 1L)), new Document("$limit", 10L)));
        result.forEach(doc->
                posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}

package com.zthulj.blog.repository;

import com.zthulj.blog.dto.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BlogRepository extends MongoRepository<Article,String> {
    Article findByLinkIgnoreCase(String link);

    List<Article> findByValue_ContentMDContainingIgnoreCaseOrTitleContainingIgnoreCase(String content, String content2);

    List<Article> findByCategory(String category);

}

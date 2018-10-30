package com.zthulj.blog.repository;

import com.zthulj.blog.dto.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface BlogRepository extends MongoRepository<Article,String> {
    Article findByLinkIgnoreCaseAndPublished(String link, boolean published);

    Article findByLink(String link);

    List<Article> findByPublished(boolean published);

    List<Article> findByValue_ContentMDContainingIgnoreCaseOrTitleContainingIgnoreCaseAndPublished(String content, String content2, boolean published);

    List<Article> findByCategoryAndPublished(String category, boolean published);

    List<Article> findByValue_ContentMDContainingIgnoreCaseOrTitleContainingIgnoreCase(String content, String title);
}

package com.zthulj.blog.repository;

import com.zthulj.blog.dto.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BlogRepository extends MongoRepository<Article,String> {
    Article findByLinkIgnoreCaseAndPublished(String link, boolean published);

    Article findByLink(String link);

    List<Article> findByPublished(boolean published);

    @Query("{ $and: [ { published: true }, { $or: [ { 'value.contentMD': {$regex : '.*?0.*'} }, { title: {$regex : '.*?0.*'} } ] } ] }")
    List<Article> findPublishedByKeyword(String keyword);

    List<Article> findByCategoryAndPublished(String category, boolean published);

    List<Article> findByValue_ContentMDContainingIgnoreCaseOrTitleContainingIgnoreCase(String content, String title);
}

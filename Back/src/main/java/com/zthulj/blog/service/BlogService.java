package com.zthulj.blog.service;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.repository.BlogRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Article getArticleByLink(String link){
        return blogRepository.findByLink(link);
    }

    public Pair<String,String> saveArticle(Article article){
        if((null == article.getId() || StringUtils.isEmpty(article.getId()))
                && getArticleByLink(article.getLink()) != null){
           return new Pair<>("Error", "An article with this link already exists in the database.");
        }
        blogRepository.save(article);
        return new Pair<>("Success", "The article has been saved");
    }

    public Collection<Article> search(String keywords){
       return blogRepository.findByValue_ContentContainingIgnoreCase(keywords);
    }

    public Collection<Article> listAll() {
        return blogRepository.findAll();
    }

    public Collection<Article> listByCategory(String cat) {
        return blogRepository.findByValue_Category(cat);
    }
}


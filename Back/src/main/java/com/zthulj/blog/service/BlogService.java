package com.zthulj.blog.service;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.exception.BlogException;
import com.zthulj.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ArticleValidator validator;

    @Autowired
    MardownService mdService;

    public Article getArticleByLink(String link) {
       Article a = blogRepository.findByLinkIgnoreCase(link);
       if(a != null){
            a.getValue().setContentHtml(mdService.convertMardownToHtml(a.getValue().getContent()));
            a.getValue().setContent(null); // Set to null to improve network data load
       }
       return a;
    }

    public Article saveArticle(Article article) throws BlogException {

        validator.Validate(article);

        // Permet la génération d'un nouvel id (ne marche pas si on reçoit un id 'vide'
        article.setId(article.getId() != null && article.getId().isEmpty() ? null : article.getId());
        if (null == article.getId()
                && getArticleByLink(article.getLink()) != null) {
            throw new BlogException("Article with this link already exist");
        }

        return blogRepository.save(article);
    }

    public Collection<Article> search(String keywords) {
        return blogRepository.findByValue_ContentContainingIgnoreCase(keywords);
    }

    public Collection<Article> listAll() {
        return blogRepository.findAll();
    }

    public Collection<Article> listByCategory(String cat) {
        return blogRepository.findByValue_Category(cat);
    }
}


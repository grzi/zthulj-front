package com.zthulj.blog.api;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.dto.Blog;
import com.zthulj.blog.service.BlogService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class BlogApi {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/{link}", method = RequestMethod.GET)
    public Article<?> getArticle(@PathVariable("link") String link){
        return blogService.getArticleByLink(link);
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public Pair<String,String> pushArticle(@PathVariable("link") String link){
        return new Pair("error","This is the error message");
    }



}

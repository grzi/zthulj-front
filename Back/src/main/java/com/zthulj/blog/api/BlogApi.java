package com.zthulj.blog.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class BlogApi {
    @RequestMapping(value = "/{link}", method = RequestMethod.GET)
    public String getArticle(@PathVariable("link") String link){
        return "Hello artiffffcle";
    }
}

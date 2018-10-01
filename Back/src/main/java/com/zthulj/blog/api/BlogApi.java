package com.zthulj.blog.api;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.service.BlogService;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/blog")
public class BlogApi {

    private Logger logger = LoggerFactory.getLogger(BlogApi.class);

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/{link}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable("link") String link) {
        return blogService.getArticleByLink(link);
    }

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public Pair<String, String> pushArticle(@RequestBody Article article) {
        return blogService.saveArticle(article);
    }

    @RequestMapping(value = "/search/{keywords}", method = RequestMethod.GET)
    public Collection<?> search(@PathVariable("keywords") String keywords) {
        return blogService.search(keywords);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Collection<Article> list() {
        return blogService.listAll();
    }

    @RequestMapping(value = "/list/{cat}", method = RequestMethod.GET)
    public Collection<Article> list(@PathVariable("cat") String cat) {
        return blogService.listByCategory(cat);
    }
}

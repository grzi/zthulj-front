package com.zthulj.blog.api;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.exception.BlogException;
import com.zthulj.blog.service.BlogService;
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

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    public @ResponseBody Article pushArticle(@RequestBody Article article) {
        try {
            return blogService.saveArticle(article);
        } catch (BlogException e) {
            return null;
        }
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

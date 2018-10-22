package com.zthulj.blog.api;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.dto.Card;
import com.zthulj.blog.exception.BlogException;
import com.zthulj.blog.referential.SecurityConfig;
import com.zthulj.blog.service.BlogService;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BlogApi {

    private Logger logger = LoggerFactory.getLogger(BlogApi.class);

    @Autowired
    BlogService blogService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/{link}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable("link") String link) {
        return blogService.getArticleByLink(link);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/{category}/{link}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable("category") String category, @PathVariable("link") String link) {
        return blogService.getArticleByLink(link);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/full/{link}", method = RequestMethod.GET)
    public Article getFullArticle(@PathVariable("link") String link) {
        return blogService.getFullArticleByLink(link);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/search/{keywords}", method = RequestMethod.GET)
    public Collection<?> search(@PathVariable("keywords") String keywords) {
        return blogService.search(keywords);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/list", method = RequestMethod.GET)
    public Collection<Card> list() {
        return blogService.listAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.PUBLIC_API + "/blog/list/{cat}", method = RequestMethod.GET)
    public Collection<Card> list(@PathVariable("cat") String cat) {
        return blogService.listByCategory(cat);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = SecurityConfig.SECURED_API + "/blog/push", method = RequestMethod.POST)
    public ResponseEntity<?> pushArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(blogService.saveArticle(article),HttpStatus.OK);
        } catch (BlogException e) {
            return new ResponseEntity<>(new Pair<>("error : ", "Error while saving the article : " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}

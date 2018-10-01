package com.zthulj.blog.service;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.repository.BlogRepository;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BlogServiceTest {
    @Mock
    BlogRepository repository;

    @InjectMocks
    BlogService blogService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_saveArticle_AlreadyExists(){
        when(repository.findByLink("TEST")).thenReturn(new Article());
        Article article = new Article();
        article.setLink("TEST");
        Pair<String,String> result = blogService.saveArticle(article);
        assertEquals("Error", result.getKey());
    }

}

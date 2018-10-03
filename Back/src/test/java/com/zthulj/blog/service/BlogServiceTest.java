package com.zthulj.blog.service;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.dto.BlogPost;
import com.zthulj.blog.exception.BlogException;
import com.zthulj.blog.repository.BlogRepository;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BlogServiceTest {
    @Mock
    BlogRepository repository;

    @Mock
    ArticleValidator artValidator;

    @InjectMocks
    BlogService blogService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_saveArticle_AlreadyExists(){
        String commonLink = "LINK";
        when(repository.findByLinkIgnoreCase(commonLink)).thenReturn(new Article());

        Article a = new Article();
        a.setLink(commonLink);
        a.setValue(new BlogPost());
        a.getValue().setTitle("It's a title");
        a.getValue().setContent("This is a content");

        Executable codeToTest = () -> { blogService.saveArticle(a); };

        assertThrows(BlogException.class, codeToTest, "Article with this link already exist");
    }

}

package com.zthulj.blog.service;

import com.zthulj.blog.dto.Article;
import com.zthulj.blog.exception.BlogException;
import org.springframework.stereotype.Service;

@Service
public class ArticleValidator {
    private static final String PREFIX_ERROR_VAL = "Un champ obligatoire est manquant : ";

    public void Validate(Article a) throws BlogException {
        if (a.getLink() == null || a.getLink().isEmpty())
            throw new BlogException(PREFIX_ERROR_VAL + "link");
        if (a.getValue() == null)
            throw new BlogException(PREFIX_ERROR_VAL + "value");
        if(a.getValue().getTitle() == null || a.getValue().getTitle().isEmpty())
            throw new BlogException(PREFIX_ERROR_VAL + "value.title");
        if(a.getValue().getContent() == null || a.getValue().getContent().isEmpty())
            throw new BlogException(PREFIX_ERROR_VAL + "value.content");
    }
}

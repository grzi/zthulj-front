package com.zthulj.blog.dto;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "blog")
public class Article implements Serializable {

    private ObjectId id;
    private String link;
    private BlogPost value;

    public Article() {
    }

    public Article(String link, BlogPost val) {
        this.link = link;
        this.value = val;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public BlogPost getValue() {
        return value;
    }

    public void setValue(BlogPost val) {
        this.value = val;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getLink(), article.getLink()) &&
                Objects.equals(getValue(), article.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLink(), getValue());
    }
}

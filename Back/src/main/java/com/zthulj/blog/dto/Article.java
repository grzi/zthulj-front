package com.zthulj.blog.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "blog")
public class Article implements Serializable {

    @Id
    private String id;
    private String link;
    private String description;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId()) &&
                Objects.equals(getLink(), article.getLink()) &&
                Objects.equals(getDescription(), article.getDescription()) &&
                Objects.equals(getValue(), article.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLink(), getDescription(), getValue());
    }
}

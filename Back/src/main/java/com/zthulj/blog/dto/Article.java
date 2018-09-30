package com.zthulj.blog.dto;


import java.io.Serializable;
import java.util.Objects;

public class Article<k> implements Serializable {
    private String link;
    private k value;

    public Article() {
    }

    public Article(String link, k val) {
        this.link = link;
        this.value = val;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public k getValue() {
        return value;
    }

    public void setValue(k val) {
        this.value = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article<?> article = (Article<?>) o;
        return Objects.equals(getLink(), article.getLink()) &&
                Objects.equals(getValue(), article.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLink(), getValue());
    }
}

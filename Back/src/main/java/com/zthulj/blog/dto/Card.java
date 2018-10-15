package com.zthulj.blog.dto;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable {
    private String title;
    private String description;
    private String publishDate;
    private String category;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getTitle(), card.getTitle()) &&
                Objects.equals(getDescription(), card.getDescription()) &&
                Objects.equals(getPublishDate(), card.getPublishDate()) &&
                Objects.equals(getCategory(), card.getCategory()) &&
                Objects.equals(getLink(), card.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getPublishDate(), getCategory(), getLink());
    }
}

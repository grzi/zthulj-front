package com.zthulj.blog.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BlogPost implements Serializable {
    private String title;
    private String subtitle;
    private Date publishDate;
    private String author;
    private String content;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogPost)) return false;
        BlogPost blogPost = (BlogPost) o;
        return Objects.equals(getTitle(), blogPost.getTitle()) &&
                Objects.equals(getSubtitle(), blogPost.getSubtitle()) &&
                Objects.equals(getPublishDate(), blogPost.getPublishDate()) &&
                Objects.equals(getAuthor(), blogPost.getAuthor()) &&
                Objects.equals(getContent(), blogPost.getContent()) &&
                Objects.equals(getCategory(), blogPost.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSubtitle(), getPublishDate(), getAuthor(), getContent(), getCategory());
    }
}

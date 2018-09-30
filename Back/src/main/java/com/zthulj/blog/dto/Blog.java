package com.zthulj.blog.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Blog implements Serializable {
    private String title;
    private String subtitle;
    private Date publishDate;
    private String author;
    private String content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return Objects.equals(getTitle(), blog.getTitle()) &&
                Objects.equals(getSubtitle(), blog.getSubtitle()) &&
                Objects.equals(getPublishDate(), blog.getPublishDate()) &&
                Objects.equals(getAuthor(), blog.getAuthor()) &&
                Objects.equals(getContent(), blog.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSubtitle(), getPublishDate(), getAuthor(), getContent());
    }
}

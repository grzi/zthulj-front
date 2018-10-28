package com.zthulj.blog.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "blog")
public class Article implements Serializable {

    @Id
    private String id;
    private String link;
    private String description;
    private String title;
    private String category;
    private String subtitle;
    private Date publishDate;
    private String formattedDate;
    private String author;
    private String imageCard;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getImageCard() {
        return imageCard;
    }

    public void setImageCard(String imageCard) {
        this.imageCard = imageCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId()) &&
                Objects.equals(getLink(), article.getLink()) &&
                Objects.equals(getDescription(), article.getDescription()) &&
                Objects.equals(getTitle(), article.getTitle()) &&
                Objects.equals(getCategory(), article.getCategory()) &&
                Objects.equals(getSubtitle(), article.getSubtitle()) &&
                Objects.equals(getPublishDate(), article.getPublishDate()) &&
                Objects.equals(getFormattedDate(), article.getFormattedDate()) &&
                Objects.equals(getAuthor(), article.getAuthor()) &&
                Objects.equals(getImageCard(), article.getImageCard()) &&
                Objects.equals(getValue(), article.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLink(), getDescription(), getTitle(), getCategory(), getSubtitle(), getPublishDate(), getFormattedDate(), getAuthor(), getImageCard(), getValue());
    }
}

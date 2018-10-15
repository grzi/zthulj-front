package com.zthulj.blog.dto;

import java.io.Serializable;
import java.util.Objects;

public class BlogPost implements Serializable {


    private String contentMD;
    private String contentHtml;


    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public String getContentMD() {
        return contentMD;
    }

    public void setContentMD(String contentMD) {
        this.contentMD = contentMD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogPost)) return false;
        BlogPost blogPost = (BlogPost) o;
        return Objects.equals(getContentMD(), blogPost.getContentMD()) &&
                Objects.equals(getContentHtml(), blogPost.getContentHtml());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContentMD(), getContentHtml());
    }
}

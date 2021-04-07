package com.restfulapi.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;

    public Article(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
    public void putArticle(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Article(){}
    public long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }
}

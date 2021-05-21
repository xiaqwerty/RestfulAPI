package com.restfulapi.demo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.restfulapi.demo.dao.Views;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.text.View;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User
{
    @Id
    private long id;
    @Size(min = 2,max = 20,message = "The length of Username should be in 2~20")
    @Pattern(regexp = "^[a-z]+$",message = "Username should only be of English characters")
    private String name;
    private String password;
    private int articleNum;

    public User(long id, String name, String password, int articleNum)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.articleNum = articleNum;
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password=password;
    }
    public User(long id,String name,String password)
    {
        this.id=id;
        this.name = name;
        this.password=password;
    }
    public User()
    {
        this.name="default";
    }
    public long getId()
    {
        return id;
    }

    @JsonView(Views.Public.class)
    public String getName()
    {
        return name;
    }


    public void setId(long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getArticleNum()
    {
        return articleNum;
    }

    public void setArticleNum(int articleNum)
    {
        this.articleNum = articleNum;
    }
    public void setArticleNum(boolean ifInc)
    {
        if(ifInc)
            this.articleNum++;
    }
    @JsonView(Views.Internal.class)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}

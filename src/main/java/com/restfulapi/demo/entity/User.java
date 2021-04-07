package com.restfulapi.demo.entity;

public class User
{
    private long id;
    private String name;


    public User(long id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public User()
    {
        this.id=-1;
        this.name="default";
    }
    public long getId()
    {
        return id;
    }

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

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

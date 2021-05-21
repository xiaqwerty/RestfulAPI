package com.restfulapi.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscribe
{   @Id
    private long id;
    private long A;//关注人
    private long B;//被关注者
    public Subscribe(){}
    public Subscribe(long A, long B)
    {
        this.A = A;
        this.B = B;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getA()
    {
        return A;
    }

    public void setA(long a)
    {
        A = a;
    }

    public long getB()
    {
        return B;
    }

    public void setB(long b)
    {
        B = b;
    }
}

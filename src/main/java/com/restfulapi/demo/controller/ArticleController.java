package com.restfulapi.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.restfulapi.demo.dao.Views;
import com.restfulapi.demo.entity.Article;
import com.restfulapi.demo.entity.result.ExceptionMsg;
import com.restfulapi.demo.entity.result.Response;
import com.restfulapi.demo.entity.result.ResponseData;
import com.restfulapi.demo.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController
{
    protected Response result(ExceptionMsg msg)
    {
        return new Response(msg);
    }
    protected Response result()
    {
        return new Response();
    }
    @Autowired
    private ArticleRepository articleRepository;




    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseData getArticleList()
    {
        List<Article> list=new ArrayList<Article>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);
    }

    @RequestMapping(value="/{title}/{content}",method = RequestMethod.POST)
    public ResponseData add(@PathVariable String title, @PathVariable String content)
    {
        System.out.println("成功进入post");
        Article article=new Article(title,content);
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Response delete(@PathVariable long id)
    {
        System.out.println("成功进入delete");
        articleRepository.deleteById(id);
        return result(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value="/{id}/{title}/{content}",method = RequestMethod.PUT)
    public ResponseData update(@PathVariable long id, @PathVariable String title, @PathVariable String content)
    {
        System.out.println("成功进入put");
        Article article=articleRepository.findById(id);
        article.putArticle(title,content);
        articleRepository.saveAndFlush(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseData findArticle(@PathVariable Integer id)throws IOException
    {
        System.out.println("成功进入查询");
        Article article=articleRepository.findById(id);
        if(article!=null)
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        return new ResponseData(ExceptionMsg.FAILED,article);
    }
}

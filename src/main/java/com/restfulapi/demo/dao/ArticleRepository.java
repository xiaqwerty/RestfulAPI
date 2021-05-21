package com.restfulapi.demo.dao;

import com.restfulapi.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long>
{
    Article findById(long id);
}

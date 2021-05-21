package com.restfulapi.demo.dao;

import com.restfulapi.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findById(long id);
}

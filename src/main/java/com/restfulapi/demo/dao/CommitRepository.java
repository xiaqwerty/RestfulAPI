package com.restfulapi.demo.dao;

import com.restfulapi.demo.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit,Long>
{
    Commit findById(long id);
}

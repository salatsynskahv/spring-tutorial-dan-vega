package com.contentcalander.respository;

import com.contentcalander.model.Content;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
      SELECT * FROM 
      Content where status=:status
     """)
    List<Content> listByStatus(String status);
}

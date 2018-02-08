package com.timo.mini.repository;

import com.timo.mini.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{

    /**
     * 根据content查找
     * @param content
     * @return
     */
    @Query("select q from Question q where q.content like %:content%")
    List<Question> findContent(@Param("content") String content);

    /**
     * 根据类型查找
     * @param type
     * @return
     */
    List<Question> findByType(String type);

}

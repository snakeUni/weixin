package com.business.repository;

import com.business.domain.ArticleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface ArticleAnswerRepo extends JpaRepository<ArticleAnswer, Long> {

    /**
     * 根据questionid查找
     * @param questionId
     * @return
     */
    List<ArticleAnswer> findByQuestionId(Long questionId);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    ArticleAnswer findById(Long id);

}

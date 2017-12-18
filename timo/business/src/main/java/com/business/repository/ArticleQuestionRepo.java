package com.business.repository;

import com.business.domain.ArticleQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface ArticleQuestionRepo extends JpaRepository<ArticleQuestion, Long>{

    /**
     * 根据文章找出所有问题
     * @param articleId
     * @return
     */
    List<ArticleQuestion> findByArticleId(Long articleId);

}

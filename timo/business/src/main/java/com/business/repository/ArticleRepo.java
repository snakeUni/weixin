package com.business.repository;

import com.business.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface ArticleRepo extends JpaRepository<Article, Long>{

    /**
     * 查找所有的文章
     * @param bookId
     * @return
     */
    List<Article> findByBookId(Long bookId);

    /**
     * 查找特定书下特定的文章
     * @param bookId
     * @param en_title
     * @return
     */
    Article findByBookIdAndEnglishTitle(Long bookId, String en_title);

}

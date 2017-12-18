package com.business.service;

import com.business.domain.ArticleAnswer;
import com.business.pojo.ArticleAnswerPojo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface ArticleAnswerService {

    List<ArticleAnswerPojo> getArticleAnswers(Long questionId);

    ArticleAnswerPojo getArticlePojo(Long id);

    ArticleAnswer getArticle(Long id);

}

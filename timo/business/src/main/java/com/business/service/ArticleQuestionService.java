package com.business.service;

import com.business.pojo.ArticleQuestionPojo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface ArticleQuestionService {

    List<ArticleQuestionPojo> getArticleQuestions(Long articleId);

}

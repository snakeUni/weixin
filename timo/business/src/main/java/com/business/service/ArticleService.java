package com.business.service;

import com.business.domain.Article;
import com.business.pojo.ArticlePojo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface ArticleService {

    List<ArticlePojo> getArticlesByBookId(Long bookId);

    ArticlePojo getArticlePojo(Long bookId, String en_title);

    Article getArticle(Long bookId, String en_title);

}

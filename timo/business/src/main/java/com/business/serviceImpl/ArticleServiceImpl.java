package com.business.serviceImpl;

import com.business.domain.Article;
import com.business.pojo.ArticlePojo;
import com.business.repository.ArticleRepo;
import com.business.service.ArticleService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public List<ArticlePojo> getArticlesByBookId(Long bookId) {
        return BeanMapper.mapList(articleRepo.findByBookId(bookId), ArticlePojo.class);
    }

    @Override
    public ArticlePojo getArticlePojo(Long bookId, String en_title) {
        return BeanMapper.map(articleRepo.findByBookIdAndEnglishTitle(bookId, en_title), ArticlePojo.class);
    }

    @Override
    public Article getArticle(Long bookId, String en_title) {
        return articleRepo.findByBookIdAndEnglishTitle(bookId, en_title);
    }
}

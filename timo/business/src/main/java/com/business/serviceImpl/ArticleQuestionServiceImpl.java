package com.business.serviceImpl;

import com.business.pojo.ArticleQuestionPojo;
import com.business.repository.ArticleQuestionRepo;
import com.business.service.ArticleQuestionService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class ArticleQuestionServiceImpl implements ArticleQuestionService{

    @Autowired
    private ArticleQuestionRepo articleQuestionRepo;

    @Override
    public List<ArticleQuestionPojo> getArticleQuestions(Long articleId) {
        return BeanMapper.mapList(articleQuestionRepo.findByArticleId(articleId), ArticleQuestionPojo.class);
    }

}

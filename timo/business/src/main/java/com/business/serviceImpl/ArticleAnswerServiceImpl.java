package com.business.serviceImpl;

import com.business.domain.ArticleAnswer;
import com.business.pojo.ArticleAnswerPojo;
import com.business.repository.ArticleAnswerRepo;
import com.business.service.ArticleAnswerService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class ArticleAnswerServiceImpl implements ArticleAnswerService{

    @Autowired
    private ArticleAnswerRepo articleAnswerRepo;

    @Override
    public List<ArticleAnswerPojo> getArticleAnswers(Long questionId) {
        return BeanMapper.mapList(articleAnswerRepo.findByQuestionId(questionId), ArticleAnswerPojo.class);
    }

    @Override
    public ArticleAnswerPojo getArticlePojo(Long id) {
        return BeanMapper.map(articleAnswerRepo.findById(id), ArticleAnswerPojo.class);
    }

    @Override
    public ArticleAnswer getArticle(Long id) {
        return articleAnswerRepo.findById(id);
    }
}

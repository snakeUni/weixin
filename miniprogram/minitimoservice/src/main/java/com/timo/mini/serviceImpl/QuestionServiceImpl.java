package com.timo.mini.serviceImpl;

import com.timo.mini.domain.Question;
import com.timo.mini.manage.QuestionData;
import com.timo.mini.repository.QuestionRepo;
import com.timo.mini.service.QuestionService;
import com.timo.mini.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<QuestionData> getQuestionsByContent(String content) {
        List<Question> questionList = questionRepo.findContent(content);
        return BeanMapper.mapList(questionList, QuestionData.class);
    }

    @Override
    public List<QuestionData> getQuestionsByType(String type) {
        List<Question> questionList = questionRepo.findByType(type);
        return BeanMapper.mapList(questionList, QuestionData.class);
    }
}

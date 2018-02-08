package com.timo.mini.serviceImpl;

import com.timo.mini.domain.Answer;
import com.timo.mini.manage.AnswerData;
import com.timo.mini.repository.AnswerRepo;
import com.timo.mini.service.AnswerService;
import com.timo.mini.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepo answerRepo;

    @Override
    public List<AnswerData> getAnswersByQesId(Long questionId) {
        List<Answer> answerList = answerRepo.findByQuestionId(questionId);
        return BeanMapper.mapList(answerList, AnswerData.class);
    }

    @Override
    public List<AnswerData> getAnswersByQesIds(List<Long> questionIds) {
        List<Answer> answerList = answerRepo.findByQuestionIdIn(questionIds);
        return BeanMapper.mapList(answerList, AnswerData.class);
    }
}

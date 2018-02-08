package com.timo.mini.repository;

import com.timo.mini.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

    /**
     * 根据questionId查找
     * @param questionId
     * @return
     */
    List<Answer> findByQuestionId(Long questionId);

    /**
     * 根据数组查找  模糊查询
     * @param questionIds
     * @return
     */
    List<Answer> findByQuestionIdIn(List<Long> questionIds);

    /**
     * 查找正确答案
     * @param questionId
     * @param isCorrect
     * @return
     */
    Answer findByQuestionIdAndIsCorrect(Long questionId, int isCorrect);
}

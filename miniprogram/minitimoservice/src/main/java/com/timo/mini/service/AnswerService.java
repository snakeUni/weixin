package com.timo.mini.service;

import com.timo.mini.manage.AnswerData;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
public interface AnswerService {

    /**
     * 返回answers by questionId
     * @param questionId
     * @return
     */
    List<AnswerData> getAnswersByQesId(Long questionId);

    /**
     * 返回 answers by questionIds
     * @param questionIds
     * @return
     */
    List<AnswerData> getAnswersByQesIds(List<Long> questionIds);
}

package com.timo.mini.service;

import com.timo.mini.manage.QuestionData;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
public interface QuestionService {

    /**
     * 返回questions by content
     * @param content
     * @return
     */
    List<QuestionData> getQuestionsByContent(String content);

    /**
     * 返回questions by type
     * @param type
     * @return
     */
    List<QuestionData> getQuestionsByType(String type);

}

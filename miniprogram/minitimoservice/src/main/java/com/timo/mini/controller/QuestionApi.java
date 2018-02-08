package com.timo.mini.controller;

import com.timo.mini.manage.QuestionData;
import com.timo.mini.service.AnswerService;
import com.timo.mini.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uni on 2018/1/15.
 */
@RestController
@RequestMapping("api/question")
public class QuestionApi {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping(path = "/getQuestions", method = RequestMethod.GET)
    public Map getQuestions(@RequestParam String content, HttpServletRequest httpServletRequest) {
        List<QuestionData> questionList = questionService.getQuestionsByContent(content);
        Map map = new HashMap<>();
        map.put("response", questionList);
        return map;
    }
}

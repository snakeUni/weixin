package com.timo.mini.controller;

import com.timo.mini.manage.AnswerData;
import com.timo.mini.service.AnswerService;
import com.timo.mini.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Uni on 2018/1/15.
 */
@RestController
@RequestMapping("api/answer")
public class AnswerApi {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(path = "getAnswer", method = RequestMethod.GET)
    public Response getAnswers(@RequestParam Long questionId) {
        List<AnswerData> list = answerService.getAnswersByQesId(questionId);
        return new Response("response", list);
    }
}

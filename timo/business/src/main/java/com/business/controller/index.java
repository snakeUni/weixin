package com.business.controller;

import com.business.config.FreemarkerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Uni on 2017/12/7.
 */
@Controller
@RequestMapping("/timo/business")
public class index {

    @Autowired
    private FreemarkerConfig freemarkerConfig;

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String getPersonAccount(HttpServletRequest httpServletRequest,
                                   HttpServletResponse httpServletResponse,
                                   Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/person/index.ftl");
        return "/ftl/person/index";
    }

    @RequestMapping(value = "/punch", method = RequestMethod.GET)
    public String getPunchNotification(HttpServletRequest httpServletRequest,
                                       HttpServletResponse httpServletResponse,
                                       Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/punch/index.ftl");
        return "/ftl/punch/index";
    }

    @RequestMapping(value = "/accountbind", method = RequestMethod.GET)
    public String accountbind(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/person/bindAccount.ftl");
        return "/ftl/person/bindAccount";
    }

    @RequestMapping(value = "/findWord", method = RequestMethod.GET)
    public String findWord(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/study/findWord.ftl");
        return "/ftl/study/findWord";
    }

    @RequestMapping(value = "/daySentence", method = RequestMethod.GET)
    public String daySentence(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/study/daySentence.ftl");
        return "/ftl/study/daySentence";
    }

    @RequestMapping(value = "/tasklist", method = RequestMethod.GET)
    public String tasklist(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse,
                              Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/task/task_list.ftl");
        return "/ftl/task/task_list";
    }

    @RequestMapping(value = "/tasklist/tasklistdetail", method = RequestMethod.GET)
    public String tasklistdetail(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 Model model,
                                 @RequestParam("bookId") int bookId) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/task/task_list_detail.ftl");
        return "/ftl/task/task_list_detail";
    }

    @RequestMapping(value = "/tasklist/tasklistdetail/taskdetailinfo", method = RequestMethod.GET)
    public String tasklistdetailtemplate(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                                 Model model,
                                 @RequestParam("taskId") int taskId) {
        freemarkerConfig.resolveMap(model.asMap(), "/ftl/task/task_detail_template.ftl");
        return "/ftl/task/task_detail_template";
    }

}

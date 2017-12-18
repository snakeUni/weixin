package com.business.controller;

import com.business.config.FreemarkerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Uni on 2017/7/9.
 */
@Controller
public class IndexController {

    @Autowired
    private FreemarkerConfig freemarkerConfig;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest httpRequest, Model model) {
        freemarkerConfig.resolveMap(model.asMap(), "index.ftl");
        return "index";
    }
}

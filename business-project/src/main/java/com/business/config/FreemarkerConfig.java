package com.business.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Uni on 2017/7/9.
 */
@org.springframework.context.annotation.Configuration
public class FreemarkerConfig {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Bean
    public Configuration getFreeMarkerConfiguration() {
        return freeMarkerConfigurer.getConfiguration();
    }

    public void resolveMap(Map<String,Object> model, String templateName){
        try {
            Template template = this.getFreeMarkerConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

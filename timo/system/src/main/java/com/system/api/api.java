package com.system.api;

import com.system.domain.menu.Menu;
import com.system.pojo.messageTemplate.WxTemplateList;
import com.system.service.menu.MenuService;
import com.system.service.msgTemplateService.WxTemplateItemService;
import com.system.utils.message.TemplateMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uni on 2017/11/22.
 */
@RestController
@RequestMapping("/uni/api/wxSystem/wxTemplateList")
public class api {

    @Autowired
    private TemplateMessageUtil templateMessageUtil;
    @Autowired
    private WxTemplateItemService wxTemplateItemService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getTemplateList", method = RequestMethod.GET)
    public Map<String, Object> getResponse(HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse) {
        WxTemplateList wxTemplateList = templateMessageUtil.getTemplateList();
        Map<String, Object> map = new HashMap<>();
        map.put("result", wxTemplateList);
        return map;
    }

    @RequestMapping(value = "/addTemplateList", method = RequestMethod.GET)
    public Map<String, String> getadd(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) {
        wxTemplateItemService.saveTemplateList();
        Map<String, String> map = new HashMap<>();
        map.put("success", "success");
        return map;
    }

    @RequestMapping(value = "/deleteTemplate", method = RequestMethod.GET)
    public Map<String, String> deleteTemplate(HttpServletRequest httpServletRequest,
                                              HttpServletResponse httpServletRespons,
                                              @RequestParam(name = "templateid") String templateid) {
        String result = wxTemplateItemService.deleteTemplateById(templateid);
        Map<String, String> map = new HashMap<>();
        map.put("result", result);
        return map;
    }

    @RequestMapping(value = "/getMenu", method = RequestMethod.GET)
    public Map getMenu(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletRespons) {
        List<Menu> list = menuService.getByRoots("button");
        Map map = new HashMap<>();
        map.put("result", list);
        return map;
    }
}

package com.system.service.msgTemplateService;

import com.system.pojo.messageTemplate.WxTemplateItemData;

/**
 * Created by Uni on 2017/11/21.
 */
public interface WxTemplateItemService {

    /**
     * 根据id查找
     * @param templateId
     * @return
     */
    WxTemplateItemData getByTemplateId(String templateId);

    /**
     * 保存模板列表
     */
    void saveTemplateList();


    /**
     * 根据模板id删除相应的模板
     * @param templateid
     * @return
     */
    String deleteTemplateById(String templateid);

}

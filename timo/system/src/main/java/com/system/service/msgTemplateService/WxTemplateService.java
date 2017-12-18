package com.system.service.msgTemplateService;

import com.system.domain.WxTemplate;

/**
 * Created by Uni on 2017/11/20.
 */
public interface WxTemplateService {

    /**
     * 根据shortid来查找
     * @param shortId
     * @return
     */
    WxTemplate getByTemplateShortId(String shortId);

}

package com.system.pojo.messageTemplate;

import com.system.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/19.
 */
@Getter
@Setter
public class WxTemplateItemData extends BaseQuery {

    private String title;

    private String templateId;      //模板id

    private String content;

    private String primary_industry;

    private String deputy_industry;

    private String example;

}

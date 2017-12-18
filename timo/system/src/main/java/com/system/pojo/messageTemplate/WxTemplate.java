package com.system.pojo.messageTemplate;

import com.system.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/20.
 */
@Getter
@Setter
public class WxTemplate extends BaseQuery {

    private String templateIdShort;     //模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式

    private String templateId;          //模板id

}

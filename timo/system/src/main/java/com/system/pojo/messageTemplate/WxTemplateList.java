package com.system.pojo.messageTemplate;

import com.system.pojo.BaseQuery;
import lombok.Getter;
import lombok.Setter;
import com.system.domain.WxTemplateItem;


import java.util.List;

/**
 * Created by Uni on 2017/11/21.
 */
@Getter
@Setter
public class WxTemplateList extends BaseQuery {

    private List<WxTemplateItem> template_list;

}

package com.system.serviceImpl.msgTemplateServiceImpl;

import com.system.domain.WxTemplateItem;
import com.system.pojo.accessToken.AccessToken;
import com.system.pojo.messageTemplate.Errorcode;
import com.system.pojo.messageTemplate.WxTemplateItemData;
import com.system.pojo.messageTemplate.WxTemplateList;
import com.system.repository.msgTemplateRepository.WxTemplateItemRepository;
import com.system.service.msgTemplateService.WxTemplateItemService;
import com.system.serviceImpl.accessToken.AccessTokenService;
import com.system.utils.BeanMapper;
import com.system.utils.message.TemplateMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/21.
 */
@Service
public class WxTemplateItemServiceImpl implements WxTemplateItemService {

    @Autowired
    private WxTemplateItemRepository wxTemplateItemRepository;
    @Autowired
    private TemplateMessageUtil templateMessageUtil;
    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public WxTemplateItemData getByTemplateId(String templateId) {
        WxTemplateItem wxTemplateItem = wxTemplateItemRepository.findByTemplateId(templateId);
        return BeanMapper.map(wxTemplateItem, WxTemplateItemData.class);
    }

    @Override
    public void saveTemplateList() {
        WxTemplateList wxTemplateList = templateMessageUtil.getTemplateList();
        List<WxTemplateItem> wxTemplateItemList = wxTemplateList.getTemplate_list();
        for(WxTemplateItem wxTemplateItem : wxTemplateItemList) {
            WxTemplateItem wxTemplateItem1 = wxTemplateItemRepository.findByTemplateId(wxTemplateItem.getTemplateId());
            if(wxTemplateItem1 != null) {
            } else {
                wxTemplateItem.onCreate();
                wxTemplateItemRepository.save(wxTemplateItem);
            }
        }
    }

    @Override
    public String deleteTemplateById(String templateid) {
        AccessToken accessToken = accessTokenService.getAccessTokenFromCache();
        Errorcode errorcode = templateMessageUtil.deleteTemplate(templateid);
        WxTemplateItem wxTemplateItem = wxTemplateItemRepository.findByTemplateId(templateid);
        if(wxTemplateItem != null) {
            wxTemplateItemRepository.delete(wxTemplateItem);
        }
        if(errorcode.getErrmsg().equals("ok")) {
            return "删除成功";
        }
        return "删除失败,templateId:" + templateid + "不存在";
    }
}

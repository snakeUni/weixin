package com.system.serviceImpl.msgTemplateServiceImpl;

import com.system.domain.WxTemplate;
import com.system.repository.msgTemplateRepository.WxTemplateRepository;
import com.system.service.msgTemplateService.WxTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/20.
 */
@Service
public class WxTemplateServiceImpl implements WxTemplateService {


    @Autowired
    private WxTemplateRepository wxTemplateRepository;

    @Override
    public WxTemplate getByTemplateShortId(String shortId) {
        return wxTemplateRepository.findByTemplateIdShort(shortId);
    }

}

package com.system.serviceImpl;

import com.system.domain.WxInfo;
import com.system.pojo.WxInfoData;
import com.system.repository.WxInfoRepository;
import com.system.service.WxInfoService;
import com.system.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/12.
 */
@Service
public class WxInfoServiceImpl implements WxInfoService {

    @Autowired
    private WxInfoRepository wxInfoRepository;

    @Override
    public WxInfoData getByWxName(String wxName) {
        WxInfo wxInfo = wxInfoRepository.findByWxName(wxName);
        return BeanMapper.map(wxInfo, WxInfoData.class);
    }

}

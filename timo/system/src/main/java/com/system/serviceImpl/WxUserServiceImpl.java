package com.system.serviceImpl;

import com.system.domain.WxUser;
import com.system.pojo.WxUserData;
import com.system.repository.WxUserRepository;
import com.system.service.WxUserService;
import com.system.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/13.
 */
@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserRepository wxUserRepository;

    @Override
    public WxUserData getByOpenid(String openid) {
        WxUser wxUser = wxUserRepository.findByOpenid(openid);
        return BeanMapper.map(wxUser, WxUserData.class);
    }

    @Override
    public WxUserData getByUnionid(String unionid) {
        WxUser wxUser = wxUserRepository.findByUnionid(unionid);
        return BeanMapper.map(wxUser, WxUserData.class);
    }

    @Override
    public WxUser getByOpenId(String openid) {
        return wxUserRepository.findByOpenid(openid);
    }

    @Override
    public WxUser getByUnionId(String unionid) {
        return wxUserRepository.findByUnionid(unionid);
    }
}

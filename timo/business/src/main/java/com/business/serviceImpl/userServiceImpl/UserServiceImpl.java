package com.business.serviceImpl.userServiceImpl;

import com.business.domain.user.User;
import com.business.pojo.userPojo.UserPojo;
import com.business.repository.userRepo.UserRepo;
import com.business.service.userService.UserService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserPojo getUserByOpenIdPojo(String openId) {
        return BeanMapper.map(userRepo.findByOpenid(openId), UserPojo.class);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userRepo.findByOpenid(openId);
    }
}

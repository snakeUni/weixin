package com.timo.mini.serviceImpl;

import com.timo.mini.domain.MiniUser;
import com.timo.mini.manage.MiniUserData;
import com.timo.mini.repository.UserRepo;
import com.timo.mini.service.UserService;
import com.timo.mini.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2018/1/12.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public MiniUserData getUserByOpenId(String openId) {

        MiniUser miniUser = userRepo.findByOpenId(openId);
        return BeanMapper.map(miniUser, MiniUserData.class);

    }
}

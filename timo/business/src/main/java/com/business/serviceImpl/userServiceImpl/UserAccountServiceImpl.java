package com.business.serviceImpl.userServiceImpl;

import com.business.domain.user.UserAccount;
import com.business.pojo.userPojo.UserAccountPojo;
import com.business.repository.userRepo.UserAccountRepo;
import com.business.service.userService.UserAccountService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Override
    public UserAccountPojo getUserAccountPojo(Long userId) {
        return BeanMapper.map(userAccountRepo.findByUserId(userId), UserAccountPojo.class);
    }

    @Override
    public UserAccount getUserAccount(Long userId) {
        return userAccountRepo.findByUserId(userId);
    }
}

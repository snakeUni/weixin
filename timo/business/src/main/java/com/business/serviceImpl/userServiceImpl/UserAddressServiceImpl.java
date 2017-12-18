package com.business.serviceImpl.userServiceImpl;

import com.business.domain.user.UserAddress;
import com.business.pojo.userPojo.UserAddressPojo;
import com.business.repository.userRepo.UserAddressRepo;
import com.business.service.userService.UserAddressService;
import com.business.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Service
public class UserAddressServiceImpl implements UserAddressService{

    @Autowired
    private UserAddressRepo userAddressRepo;

    @Override
    public List<UserAddressPojo> getUserAddresses(Long userId) {
        return BeanMapper.mapList(userAddressRepo.findByUsedId(userId), UserAddressPojo.class);
    }

    @Override
    public UserAddressPojo getUserAddressPojo(Long id) {
        return BeanMapper.map(userAddressRepo.findById(id), UserAddressPojo.class);
    }

    @Override
    public UserAddress getUserAddress(Long id) {
        return userAddressRepo.findById(id);
    }
}

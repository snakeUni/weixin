package com.business.service.userService;

import com.business.domain.user.UserAddress;
import com.business.pojo.userPojo.UserAddressPojo;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
public interface UserAddressService {

    List<UserAddressPojo> getUserAddresses(Long userId);

    UserAddressPojo getUserAddressPojo(Long id);

    UserAddress getUserAddress(Long id);

}

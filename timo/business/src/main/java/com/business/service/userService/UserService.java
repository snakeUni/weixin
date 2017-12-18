package com.business.service.userService;

import com.business.domain.user.User;
import com.business.pojo.userPojo.UserPojo;

/**
 * Created by Uni on 2017/11/30.
 */
public interface UserService {

    UserPojo getUserByOpenIdPojo(String openId);

    User getUserByOpenId(String openId);

}

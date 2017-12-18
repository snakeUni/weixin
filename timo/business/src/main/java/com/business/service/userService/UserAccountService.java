package com.business.service.userService;

import com.business.domain.user.UserAccount;
import com.business.pojo.userPojo.UserAccountPojo;

/**
 * Created by Uni on 2017/11/30.
 */
public interface UserAccountService {

    UserAccountPojo getUserAccountPojo(Long userId);

    UserAccount getUserAccount(Long userId);

}

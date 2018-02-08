package com.timo.mini.service;

import com.timo.mini.manage.AccountData;

/**
 * Created by Uni on 2018/1/13.
 */
public interface AccountService {

    /**
     * 返回 account by userid
     * @param userId
     * @return
     */
    AccountData getAccountByUserId(Long userId);
}

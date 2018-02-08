package com.timo.mini.serviceImpl;

import com.timo.mini.domain.Account;
import com.timo.mini.manage.AccountData;
import com.timo.mini.repository.AccountRepo;
import com.timo.mini.service.AccountService;
import com.timo.mini.utils.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uni on 2018/1/13.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public AccountData getAccountByUserId(Long userId) {
        Account account = accountRepo.findByUserId(userId);
        return BeanMapper.map(account, AccountData.class);
    }
}

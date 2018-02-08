package com.timo.mini.repository;

import com.timo.mini.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2018/1/12.
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    /**
     * 根据userid查找
     * @param userId
     * @return
     */
    Account findByUserId(Long userId);
}

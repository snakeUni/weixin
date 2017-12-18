package com.business.repository.userRepo;

import com.business.domain.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Long>{

    /**
     * 根据用户的userId来查找
     * @param userId
     * @return
     */
    UserAccount findByUserId(Long userId);

}

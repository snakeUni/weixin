package com.business.repository.userRepo;

import com.business.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long>{

    /**
     * 根据openId查找
     * @param openId
     * @return
     */
    User findByOpenid(String openId);

}

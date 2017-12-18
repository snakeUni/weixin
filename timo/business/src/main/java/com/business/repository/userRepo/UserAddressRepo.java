package com.business.repository.userRepo;

import com.business.domain.user.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Uni on 2017/11/30.
 */
@Repository
public interface UserAddressRepo extends JpaRepository<UserAddress, Long>{

    /**
     * 获取用户的所有地址
     * @param userId
     * @return
     */
    List<UserAddress> findByUsedId(Long userId);

    /**
     * 获得其中一个地址
     * @param id
     * @return
     */
    UserAddress findById(Long id);

}

package com.system.repository;

import com.system.domain.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/13.
 */
@Repository
public interface WxUserRepository extends JpaRepository<WxUser, Long> {

    /**
     * 根据openId查找
     * @param openid
     * @return
     */
    WxUser findByOpenid(String openid);

    /**
     * 根据unionid查找
     * @param unionid
     * @return
     */
    WxUser findByUnionid(String unionid);

}

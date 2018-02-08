package com.timo.mini.repository;

import com.timo.mini.domain.MiniUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2018/1/12.
 */
@Repository
public interface UserRepo extends JpaRepository<MiniUser, Long>{

    /**
     * 根据openid查找
     * @param openId
     * @return
     */
    MiniUser findByOpenId(String openId);

}

package com.system.repository;

import com.system.domain.WxInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/12.
 */
@Repository
public interface WxInfoRepository extends JpaRepository<WxInfo, Long>{

    /**
     * 根据wxName来查找
     * @param wxName
     * @return
     */
    WxInfo findByWxName(String wxName);
}

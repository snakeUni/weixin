package com.system.repository;

import com.system.domain.WxMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/21.
 */
@Repository
public interface WxMessageRepository extends JpaRepository<WxMessage, Long> {

}

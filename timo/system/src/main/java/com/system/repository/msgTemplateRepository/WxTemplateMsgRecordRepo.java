package com.system.repository.msgTemplateRepository;

import com.system.domain.WxTemplateMsgRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/22.
 */
@Repository
public interface WxTemplateMsgRecordRepo extends JpaRepository<WxTemplateMsgRecord, Long> {
}

package com.system.repository.msgTemplateRepository;

import com.system.domain.WxTemplateItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/21.
 */
@Repository
public interface WxTemplateItemRepository extends JpaRepository<WxTemplateItem, Long>{

    /**
     * 根据模板id查询
     * @param templateId
     * @return
     */
    WxTemplateItem findByTemplateId(String templateId);

}

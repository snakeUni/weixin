package com.system.repository.msgTemplateRepository;

import com.system.domain.WxTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Uni on 2017/11/20.
 */
@Repository
public interface WxTemplateRepository extends JpaRepository<WxTemplate, Long> {

    /**
     * 根据shortid来查找
     * @param templateidshort
     * @return
     */
    WxTemplate findByTemplateIdShort(String templateidshort);

}

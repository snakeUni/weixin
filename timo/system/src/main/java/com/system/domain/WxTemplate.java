package com.system.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2017/11/20.
 */
@Getter
@Setter
@Entity
@Table(name = "WX_TEMPLATE")
public class WxTemplate extends BaseEntity {

    private String templateIdShort;     //模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式

    private String templateId;          //模板id

}

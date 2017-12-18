package com.business.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Uni on 2017/11/28.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                      // 实体id

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;                             // 新建时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;                             // 最后更新时间

    private Long createdByUserId;                         // 新建用户id

    private String createdByUsername;                     // 新建用户名称

    /**
     * 新建实体时，更新新建时间
     */
    public void onCreate() {
        this.createdTime = new Date();
    }

    /**
     * 编辑实体时，更新最后编辑时间
     */
    public void onUpdate() {
        this.updatedTime = new Date();
    }
}

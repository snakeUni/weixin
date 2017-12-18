package com.system.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Uni on 2017/11/12.
 */
@Getter
@Setter
public abstract class BaseQuery implements Serializable{

    private Long id;                                      // 实体id

    private Date createdTime;                             // 新建时间

    private Date updatedTime;                             // 最后更新时间

    private Long createdByUserId;                         // 新建用户id

    private String createdByUsername;                     // 新建用户名称
}

package com.timo.mini.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                            // 实体id

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;                                   // 新建时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;                              // 最后更新时间

}

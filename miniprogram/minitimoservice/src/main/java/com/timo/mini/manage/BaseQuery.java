package com.timo.mini.manage;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
public abstract class BaseQuery implements Serializable{

    private Long id;

    private Date createdTime;

    private Date lastModifiedTime;
}

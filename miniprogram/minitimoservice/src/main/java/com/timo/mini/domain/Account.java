package com.timo.mini.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    private long BalanceMoney;          //账户余额

    private Long userId;                //用户id


}

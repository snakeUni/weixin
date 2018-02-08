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
@Table(name = "TRADE_RECORDS")
public class TradeRecords extends BaseEntity {

    private long money;         //提现或者充值的钱

    private int type;           //类型 1:充值到账户 2:提现出账号    3:充值会员

    private Long userId;        //用户id

}

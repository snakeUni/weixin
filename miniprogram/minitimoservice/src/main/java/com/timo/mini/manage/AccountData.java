package com.timo.mini.manage;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
public class AccountData extends BaseQuery {

    private long BalanceMoney;          //账户余额

    private Long userId;                //用户id

}

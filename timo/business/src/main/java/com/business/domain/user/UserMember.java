package com.business.domain.user;

/**
 * Created by Uni on 2017/11/28.
 */
public enum UserMember {

    BlackIronMember(0),
    SliverMember(1),
    GoldMember(2),
    PlatinumMember(3),
    DiamondMember(4),
    KingMember(5);

    private int level;

    UserMember(int level) {
        this.level = level;
    }
}

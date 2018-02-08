package com.timo.mini.domain;

/**
 * Created by Uni on 2018/1/23.
 */
public enum Level {

    VeryEasy(1),
    Easy(2),
    Middle(3),
    Diffcult(4),
    VeryDiffcult(5);

    private int title;

    Level(int title) {
        this.title = title;
    }
}

package com.timo.mini.manage;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
public class AnswerData extends BaseQuery {

    private Long questionId;        //问题的id

    private String content;         //答案内容

    private int isCorrect;          //是否是正确答案   1:正确    0:错误

}

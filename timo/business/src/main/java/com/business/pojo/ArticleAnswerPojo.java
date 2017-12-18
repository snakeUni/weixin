package com.business.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class ArticleAnswerPojo extends BaseQuery {

    private Long questionId;        //题目的id

    private String content;         //题目的内容

    private int correct;            //是否是正确答案 1:正确答案 0:错误答案

}

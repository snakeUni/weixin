package com.timo.mini.manage;

import com.timo.mini.domain.Answer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
public class QuestionData extends BaseQuery {

    private String content;       //提莫

    private String type;        //所属类型

    private String keyword;    //关键词

    private List<Answer> children;

}

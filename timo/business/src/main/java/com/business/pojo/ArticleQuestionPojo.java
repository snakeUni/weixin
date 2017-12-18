package com.business.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class ArticleQuestionPojo extends BaseQuery{

    private Long articleId;     //对应文章的id

    private String content;     //题目内容

}

package com.business.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Uni on 2017/11/30.
 */
@Getter
@Setter
public class ArticlePojo extends BaseQuery {

    private String englishTitle;        //英文题目

    private String chineseTitle;        //中文标题

    private String englishContent;     //文章英文内容

    private String chineseContent;     //文章中文内容

    private String anthor;             //文章作者

    private Long bookId;                //书本id

}

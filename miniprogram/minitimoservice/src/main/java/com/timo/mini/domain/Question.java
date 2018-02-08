package com.timo.mini.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@Entity
@Table(name = "QUESTION")
public class Question extends BaseEntity {

    private String content;         //提莫

    private String type;            //所属类型

    private String keyword;         //关键词

    private String keyword2;        //关键词2

    private String keyword3;        //关键词3

    @Enumerated(EnumType.ORDINAL)   //困难程度
    private Level level;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> children;


}

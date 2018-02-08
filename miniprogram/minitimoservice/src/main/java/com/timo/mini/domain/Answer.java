package com.timo.mini.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Uni on 2018/1/12.
 */
@Getter
@Setter
@Table(name = "ANSWER")
@Entity
public class Answer extends BaseEntity {

    private String content;         //答案内容

    private int isCorrect;          //是否是正确答案   1:正确    0:错误

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;

}

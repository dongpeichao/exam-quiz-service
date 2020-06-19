package com.thoughtworks.exam.quiz.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryQuizDTO {
    private String id;
    private String teacherId;
    private String question;
    private Integer score;
    private String referenceAnswer;
}

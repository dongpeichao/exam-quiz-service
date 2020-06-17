package com.thoughtworks.exam.quiz;

import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;

public class Test {

    @org.junit.Test
    public void test() {
        System.out.println(BlankQuizId.generate().getValue());
    }
}

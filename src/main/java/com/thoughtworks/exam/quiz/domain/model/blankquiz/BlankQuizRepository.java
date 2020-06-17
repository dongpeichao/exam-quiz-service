package com.thoughtworks.exam.quiz.domain.model.blankquiz;

import java.util.Optional;

public interface BlankQuizRepository {
    void save(BlankQuiz blankQuiz);

    Optional<BlankQuiz> findById(BlankQuizId blankQuizId);
}

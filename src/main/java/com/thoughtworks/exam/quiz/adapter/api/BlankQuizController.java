package com.thoughtworks.exam.quiz.adapter.api;

import com.thoughtworks.exam.quiz.application.BlankQuizApplicationService;
import com.thoughtworks.exam.quiz.application.CreateQuizCommand;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.IllegalScoreException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
public class BlankQuizController {
    private BlankQuizApplicationService blankQuizApplicationService;

    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlankQuizDTO create(@RequestBody CreateQuizCommand command) throws IllegalScoreException {
        return BlankQuizDTO.from(blankQuizApplicationService.createQuiz(command).toString());
    }

    @PutMapping("/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("blankQuizId") String blankQuizId, @RequestBody CreateQuizCommand command) throws IllegalScoreException {
        blankQuizApplicationService.updateQuiz(new BlankQuizId(blankQuizId), command);
    }
}

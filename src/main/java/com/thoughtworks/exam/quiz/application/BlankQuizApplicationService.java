package com.thoughtworks.exam.quiz.application;

import com.thoughtworks.exam.quiz.adapter.api.QueryQuizDTO;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuiz;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizId;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.BlankQuizRepository;
import com.thoughtworks.exam.quiz.domain.model.blankquiz.IllegalScoreException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlankQuizApplicationService {
    private final BlankQuizRepository blankQuizRepository;

    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId createQuiz(final CreateQuizCommand command) throws IllegalScoreException {
        BlankQuiz blankQuiz = BlankQuiz.create(command.getTeacherId(), command.getQuestion(),
                command.getScore(), command.getReferenceAnswer());
        blankQuizRepository.save(blankQuiz);
        return blankQuiz.getId();
    }

    public void updateQuiz(BlankQuizId blankQuizId, CreateQuizCommand command) {
        Optional<BlankQuiz> blankQuizOptional = blankQuizRepository.findById(blankQuizId);

        blankQuizOptional.ifPresent(blankQuiz -> {
            blankQuiz.update(blankQuizId, command.getTeacherId(), command.getQuestion(),
                    command.getScore(), command.getReferenceAnswer());
            blankQuizRepository.save(blankQuiz);
        });

    }

    public QueryQuizDTO query(String blankQuizId) {
        Optional<BlankQuiz> blankQuizOptional = blankQuizRepository.findById(new BlankQuizId(blankQuizId));
        return blankQuizOptional.map(blankQuiz -> new QueryQuizDTO(blankQuiz.getId().getValue(),
                blankQuiz.getTeacherId(), blankQuiz.getContent(), blankQuiz.getScore(),
                blankQuiz.getReferenceAnswer())).orElse(null);
    }
}

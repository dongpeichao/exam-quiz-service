package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create a blank quiz"

    request {
        url "/quizzes"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: regex('[a-zA-Z0-9]{36}'),
                question: regex('.{1,255}'),
                score: anyNumber(),
                referenceAnswer: regex('.{1,4000}')
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                blankQuizId: "90fdknaf09fopfkmald"
        )
    }
}
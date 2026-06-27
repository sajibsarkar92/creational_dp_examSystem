package com.examSystem.abstractfactory.truefalse;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;

public class TrueFalseEvaluator implements QuestionEvaluator {

    @Override
    public double evaluate(Question question, String submittedAnswer) {
        
        if (!(question instanceof TrueFalseQuestion)) {
            System.out.println("Error: TrueFalseEvaluator can only evaluate TrueFalseQuestion.");
            return 0.0;
        }

        TrueFalseQuestion tfq = (TrueFalseQuestion) question;
        String correctAnswer = tfq.getCorrectAnswer();
        
        String cleanSubmission = submittedAnswer.trim();
        String cleanCorrect = correctAnswer.trim();

        double obtainedPoints = 1.0;
        double zeroPoints = 0.0;

        if (cleanSubmission.equalsIgnoreCase(cleanCorrect)) {
            return obtainedPoints;
        } else {
            return zeroPoints;
        }
    }
}

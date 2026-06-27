package com.examSystem.abstractfactory.mcq;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;

public class MCQEvaluator implements QuestionEvaluator {

    @Override
    public double evaluate(Question question, String submittedAnswer) {
        
        if (!(question instanceof MCQQuestion)) {
            System.out.println("Error: MCQEvaluator can only evaluate MCQQuestion.");
            return 0.0;
        }

        MCQQuestion mcq = (MCQQuestion) question;
        String correctAnswer = mcq.getCorrectAnswer();

        if (submittedAnswer == null) {
            return 0.0;
        }

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

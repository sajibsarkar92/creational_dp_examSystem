package com.examSystem.abstractfactory.programming;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;

public class ProgrammingEvaluator implements QuestionEvaluator {

    @Override
    public double evaluate(Question question, String submittedAnswer) {
        
        if (!(question instanceof ProgrammingQuestion)) {
            System.out.println("Error: ProgrammingEvaluator can only evaluate ProgrammingQuestion.");
            return 0.0;
        }

        double obtainedPoints = 1.0;
        double zeroPoints = 0.0;

        if (submittedAnswer != null && (submittedAnswer.contains("class") || submittedAnswer.contains("return"))) {
            return obtainedPoints; 
        } else {
            return zeroPoints;
        }
    }
}

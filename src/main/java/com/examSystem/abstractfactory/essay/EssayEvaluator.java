package com.examSystem.abstractfactory.essay;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;

public class EssayEvaluator implements QuestionEvaluator {

    @Override
    public double evaluate(Question question, String submittedAnswer) {
        
        if (!(question instanceof EssayQuestion)) {
            System.out.println("Error: EssayEvaluator can only evaluate EssayQuestion.");
            return 0.0;
        }

      
        double obtainedPoints = 1.0;
        double zeroPoints = 0.0;

        if (submittedAnswer != null && submittedAnswer.trim().length() > 20) {
            return obtainedPoints; 
        } else {
            return zeroPoints;
        }
    }
}

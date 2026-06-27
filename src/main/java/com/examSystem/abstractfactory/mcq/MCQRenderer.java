package com.examSystem.abstractfactory.mcq;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionRenderer;
import java.util.List;

public class MCQRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        
        if (!(question instanceof MCQQuestion)) {
            System.out.println("Error: MCQRenderer can only render MCQQuestion.");
            return;
        }

        MCQQuestion mcq = (MCQQuestion) question;
        
        System.out.println(mcq.getQuestionText());
        
        List<String> options = mcq.getOptions();
        
        for (String option : options) {
            System.out.println("  " + option);
        }
    }
}

package com.examSystem.abstractfactory.essay;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionRenderer;

public class EssayRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        
        if (!(question instanceof EssayQuestion)) {
            System.out.println("Error: EssayRenderer can only render EssayQuestion.");
            return;
        }

        EssayQuestion essay = (EssayQuestion) question;
        
        System.out.println(essay.getQuestionText());
        System.out.println("  ___________________________________________________");
        System.out.println("  ___________________________________________________");
    }
}

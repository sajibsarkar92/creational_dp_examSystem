package com.examSystem.abstractfactory.truefalse;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionRenderer;

public class TrueFalseRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        
        if (!(question instanceof TrueFalseQuestion)) {
            System.out.println("Error: TrueFalseRenderer can only render TrueFalseQuestion.");
            return;
        }

        TrueFalseQuestion tfq = (TrueFalseQuestion) question;
        
        System.out.println(tfq.getQuestionText());
        System.out.println("  [ ] True");
        System.out.println("  [ ] False");
    }
}

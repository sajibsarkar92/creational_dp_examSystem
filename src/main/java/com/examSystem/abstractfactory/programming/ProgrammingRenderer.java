package com.examSystem.abstractfactory.programming;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionRenderer;

public class ProgrammingRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        
        if (!(question instanceof ProgrammingQuestion)) {
            System.out.println("Error: ProgrammingRenderer can only render ProgrammingQuestion.");
            return;
        }

        ProgrammingQuestion pq = (ProgrammingQuestion) question;
        
        System.out.println(pq.getQuestionText());
        System.out.println("  ```java");
        System.out.println("  // Write your code here...");
        System.out.println("  ```");
    }
}

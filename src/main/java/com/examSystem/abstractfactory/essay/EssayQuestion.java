package com.examSystem.abstractfactory.essay;

import com.examSystem.abstractfactory.Question;

public class EssayQuestion implements Question {

    private String questionText;

    public EssayQuestion(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String getQuestionText() {
        return this.questionText;
    }
}

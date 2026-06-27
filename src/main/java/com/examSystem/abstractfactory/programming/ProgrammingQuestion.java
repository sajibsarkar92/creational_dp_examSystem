package com.examSystem.abstractfactory.programming;

import com.examSystem.abstractfactory.Question;

public class ProgrammingQuestion implements Question {

    private String questionText;

    public ProgrammingQuestion(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String getQuestionText() {
        return this.questionText;
    }
}

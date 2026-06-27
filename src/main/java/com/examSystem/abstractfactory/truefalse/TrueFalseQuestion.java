package com.examSystem.abstractfactory.truefalse;

import com.examSystem.abstractfactory.Question;

public class TrueFalseQuestion implements Question {
    
    private String questionText;
    private String correctAnswer;

    public TrueFalseQuestion(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestionText() {
        return this.questionText;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
}

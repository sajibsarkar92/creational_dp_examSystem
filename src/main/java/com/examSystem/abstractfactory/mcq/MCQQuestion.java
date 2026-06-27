package com.examSystem.abstractfactory.mcq;

import com.examSystem.abstractfactory.Question;
import java.util.List;

public class MCQQuestion implements Question {
    
    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public MCQQuestion(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getQuestionText() {
        return this.questionText;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
}

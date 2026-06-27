package com.examSystem.abstractfactory.truefalse;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.QuestionRenderer;
import com.examSystem.source.QuestionSource;

public class TrueFalseFactory implements QuestionFactory {

    private QuestionSource source;

    public TrueFalseFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
        String rawData = source.getQuestionData("TrueFalse");

        String[] parts = rawData.split("\\|");
        
        String questionText = parts[0];
        String correctAnswer = parts[1];

        return new TrueFalseQuestion(questionText, correctAnswer);
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new TrueFalseRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new TrueFalseEvaluator();
    }
}

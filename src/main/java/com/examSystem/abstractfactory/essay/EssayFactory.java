package com.examSystem.abstractfactory.essay;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.QuestionRenderer;
import com.examSystem.source.QuestionSource;

public class EssayFactory implements QuestionFactory {

    private QuestionSource source;

    public EssayFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
       
        String rawData = source.getQuestionData("Essay");

        return new EssayQuestion(rawData);
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new EssayRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new EssayEvaluator();
    }
}

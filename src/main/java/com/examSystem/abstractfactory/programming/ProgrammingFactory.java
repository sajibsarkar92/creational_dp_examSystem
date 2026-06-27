package com.examSystem.abstractfactory.programming;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.QuestionRenderer;
import com.examSystem.source.QuestionSource;

public class ProgrammingFactory implements QuestionFactory {

    private QuestionSource source;

    public ProgrammingFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
        
       
        String rawData = source.getQuestionData("Programming");

        return new ProgrammingQuestion(rawData);
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new ProgrammingRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new ProgrammingEvaluator();
    }
}

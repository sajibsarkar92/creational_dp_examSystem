package com.examSystem.abstractfactory.mcq;

import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionEvaluator;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.QuestionRenderer;
import com.examSystem.source.QuestionSource;

import java.util.Arrays;
import java.util.List;

public class MCQFactory implements QuestionFactory {

    private QuestionSource source;

    public MCQFactory(QuestionSource source) {
        this.source = source;
    }

    @Override
    public Question createQuestion() {
        String rawData = source.getQuestionData("MCQ");

        String[] parts = rawData.split("\\|");

        if (parts.length < 3) {
            return new MCQQuestion(rawData, List.of("N/A"), "N/A");
        }

        String questionText = parts[0];
        List<String> options = Arrays.asList(parts).subList(1, parts.length - 1);
        String correctAnswer = parts[parts.length - 1];

        return new MCQQuestion(questionText, options, correctAnswer);
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new MCQRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new MCQEvaluator();
    }
}

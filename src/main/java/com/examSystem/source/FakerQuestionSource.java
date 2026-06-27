package com.examSystem.source;

public class FakerQuestionSource implements QuestionSource {

    private int counter = 1;

    @Override
    public String getQuestionData(String type) {
        return "Auto-generated " + type + " question #" + (counter++);
    }
}

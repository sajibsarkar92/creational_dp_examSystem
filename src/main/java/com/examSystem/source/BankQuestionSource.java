package com.examSystem.source;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BankQuestionSource implements QuestionSource {

    private final Map<String, List<String>> questionBank;
    private final Random random;

    public BankQuestionSource() {
        this.random = new Random();
        this.questionBank = new HashMap<>();
        
        questionBank.put("MCQ", List.of(
            "What is the capital of France?|A) London|B) Berlin|C) Paris|D) Madrid|C",
            "Which design pattern ensures a class has only one instance?|A) Factory|B) Singleton|C) Builder|D) Prototype|B"
        ));
        
        questionBank.put("Essay", List.of(
            "Explain the difference between Abstract Factory and Factory Method.",
            "Discuss the impacts of global warming on coastal cities."
        ));

        questionBank.put("TrueFalse", List.of(
            "Java is a compiled language.|False",
            "The Earth is flat.|False"
        ));

        questionBank.put("Programming", List.of(
            "Write a function to reverse a string in Java.",
            "Implement a binary search algorithm."
        ));
    }

    @Override 
    public String getQuestionData(String type) {
        List<String> questions = questionBank.get(type);

        
        if (questions == null || questions.isEmpty()) {
            return "No questions available for this type.";
        }

        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }

}

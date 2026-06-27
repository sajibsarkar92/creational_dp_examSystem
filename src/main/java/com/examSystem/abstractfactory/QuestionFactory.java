package com.examSystem.abstractfactory;

public interface QuestionFactory {
    
    Question createQuestion();
    
    QuestionRenderer createRenderer();
    
    QuestionEvaluator createEvaluator();
    
}

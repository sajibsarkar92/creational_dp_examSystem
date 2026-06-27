package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;

import java.util.List;

public abstract class ExamFactory {
    
   
    public abstract Exam createExam(ExamConfiguration config, List<QuestionFactory> questionFactories);

}

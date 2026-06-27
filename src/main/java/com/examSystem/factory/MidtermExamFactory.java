package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;

import java.util.List;

public class MidtermExamFactory extends ExamFactory {

    @Override
    public Exam createExam(ExamConfiguration config, List<QuestionFactory> questionFactories) {
        

        return new MidtermExam(config, questionFactories);
        
    }
}

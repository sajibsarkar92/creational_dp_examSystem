package com.examSystem;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.source.QuestionSource;
import com.examSystem.source.BankQuestionSource;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.mcq.MCQFactory;
import com.examSystem.abstractfactory.essay.EssayFactory;
import com.examSystem.abstractfactory.truefalse.TrueFalseFactory;
import com.examSystem.abstractfactory.programming.ProgrammingFactory;
import com.examSystem.factory.ExamFactory;
import com.examSystem.factory.MidtermExamFactory;
import com.examSystem.factory.Exam;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Starting Examination System Initialization...\n");

        QuestionSource source = new BankQuestionSource();

        ExamConfiguration config = new ExamConfiguration.Builder()
                .setTitle("Object-Oriented Design Patterns")
                .setDuration(120)
                .setPassingScore(60)
                .enableNegativeMarking()
                .enableQuestionShuffle()
                .enableAutoSubmit()
                .allowCalculator()
                .build();

        List<QuestionFactory> questionFactories = new ArrayList<>();
        questionFactories.add(new MCQFactory(source));
        questionFactories.add(new EssayFactory(source));
        questionFactories.add(new TrueFalseFactory(source));
        questionFactories.add(new ProgrammingFactory(source));

        ExamFactory examFactory = new MidtermExamFactory();
        Exam midterm = examFactory.createExam(config, questionFactories);

        midterm.displayDashboard();
        
        midterm.takeExam();
        
    }
}

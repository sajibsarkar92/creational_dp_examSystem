package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;

import java.util.List;

public class PracticeQuiz extends AbstractExam {

    public PracticeQuiz(ExamConfiguration config, List<QuestionFactory> questionFactories) {
        super(config, questionFactories);
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n=== Practice Quiz: " + config.getTitle() + " ===");
        System.out.println("Duration: " + config.getDuration() + " mins | Passing Score: " + config.getPassingScore());
        System.out.println("This is a low-stakes practice environment.");
        System.out.println("---------------------------------------------------");

        printQuestions();
    }
}

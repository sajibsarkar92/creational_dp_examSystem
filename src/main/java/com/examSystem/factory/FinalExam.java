package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;

import java.util.List;

public class FinalExam extends AbstractExam {

    public FinalExam(ExamConfiguration config, List<QuestionFactory> questionFactories) {
        super(config, questionFactories);
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n=== FINAL EXAM: " + config.getTitle() + " ===");
        System.out.println("Duration: " + config.getDuration() + " mins");
        System.out.println("WARNING: High Stakes. Auto-submit is " + (config.isAutoSubmit() ? "ON." : "OFF."));
        System.out.println("Calculator Allowed: " + (config.isCalculatorAllowed() ? "YES" : "NO"));
        System.out.println("---------------------------------------------------");

        printQuestions();
    }
}

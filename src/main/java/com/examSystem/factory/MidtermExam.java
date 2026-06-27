package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;

import java.util.List;

public class MidtermExam extends AbstractExam {

    public MidtermExam(ExamConfiguration config, List<QuestionFactory> questionFactories) {
        super(config, questionFactories);
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n=== Midterm Exam: " + config.getTitle() + " ===");
        System.out.println("Duration: " + config.getDuration() + " mins");
        System.out.println("Negative Marking: " + (config.isNegativeMarking() ? "YES" : "NO"));
        System.out.println("Proctored: YES");
        System.out.println("---------------------------------------------------");

        printQuestions();
    }
}

package com.examSystem.factory;

import com.examSystem.builder.ExamConfiguration;
import com.examSystem.abstractfactory.QuestionFactory;
import com.examSystem.abstractfactory.Question;
import com.examSystem.abstractfactory.QuestionRenderer;
import com.examSystem.abstractfactory.QuestionEvaluator;

import java.util.List;
import java.util.Scanner;

public class FinalExam implements Exam {

    private ExamConfiguration config;
    private List<QuestionFactory> questionFactories;

    public FinalExam(ExamConfiguration config, List<QuestionFactory> questionFactories) {
        this.config = config;
        this.questionFactories = questionFactories;
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n=== FINAL EXAM: " + config.getTitle() + " ===");
        System.out.println("Duration: " + config.getDuration() + " mins");
        System.out.println("WARNING: High Stakes. Auto-submit is " + (config.isAutoSubmit() ? "ON." : "OFF."));
        System.out.println("Calculator Allowed: " + (config.isCalculatorAllowed() ? "YES" : "NO"));
        System.out.println("---------------------------------------------------");

        int index = 1;
        for (QuestionFactory qf : questionFactories) {
            Question q = qf.createQuestion();
            QuestionRenderer r = qf.createRenderer();
            
            System.out.print("Q" + index + ". ");
            r.render(q);
            System.out.println();
            index++;
        }
    }

    @Override
    public void takeExam() {
        Scanner scanner = new Scanner(System.in);
        double totalScore = 0.0;
        double maxScore = 0.0;

        System.out.println("\n--- Exam Started ---");
        int index = 1;
        
        for (QuestionFactory qf : questionFactories) {
            Question q = qf.createQuestion();
            QuestionRenderer r = qf.createRenderer();
            QuestionEvaluator e = qf.createEvaluator();
            
            System.out.print("Q" + index + ". ");
            r.render(q);
            
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            
            double score = e.evaluate(q, answer);
            totalScore += score;
            maxScore += 1.0; 
            
            System.out.println();
            index++;
        }
        
        System.out.println("=== Exam Completed ===");
        System.out.println("Total Score: " + totalScore + " / " + maxScore);
        
        double percentage = (totalScore / maxScore) * 100;
        if (percentage >= config.getPassingScore()) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
        
        scanner.close();
    }
}

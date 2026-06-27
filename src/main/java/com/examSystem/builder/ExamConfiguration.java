package com.examSystem.builder;

public class ExamConfiguration {

    private String title;
    private int duration;
    private int passingScore;
    private boolean negativeMarking;
    private boolean questionShuffle;
    private boolean autoSubmit;
    private boolean calculatorAllowed;

    
    private ExamConfiguration() {}

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public int getPassingScore() { return passingScore; }
    public boolean isNegativeMarking() { return negativeMarking; }
    public boolean isQuestionShuffle() { return questionShuffle; }
    public boolean isAutoSubmit() { return autoSubmit; }
    public boolean isCalculatorAllowed() { return calculatorAllowed; }

    public static class Builder {

        private ExamConfiguration config = new ExamConfiguration();

        public Builder setTitle(String title) {
            config.title = title;
            return this;
        }

        public Builder setDuration(int durationMinutes) {
            config.duration = durationMinutes;
            return this;
        }

        public Builder setPassingScore(int passingScore) {
            config.passingScore = passingScore;
            return this;
        }

        public Builder enableNegativeMarking() {
            config.negativeMarking = true;
            return this;
        }

        public Builder enableQuestionShuffle() {
            config.questionShuffle = true;
            return this;
        }

        public Builder enableAutoSubmit() {
            config.autoSubmit = true;
            return this;
        }

        public Builder allowCalculator() {
            config.calculatorAllowed = true;
            return this;
        }

        public ExamConfiguration build() {
            if (config.title == null || config.title.isBlank())
                throw new IllegalStateException("Title is required.");
            if (config.duration <= 0)
                throw new IllegalStateException("Duration must be positive.");
            return config;
        }
    }
}

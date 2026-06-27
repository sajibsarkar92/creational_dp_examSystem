# Online Examination Subsystem — Creational Design Patterns

A Java implementation of an Online Examination Subsystem demonstrating the **Factory Method**, **Abstract Factory**, and **Builder** creational design patterns, modelled after enterprise LMS platforms like Canvas / Moodle.

## Assignment

Creational Design Patterns Lab Assignment — Factory, Abstract Factory, Builder
*Course: Design Patterns*

---

## Project Structure

```
creational_design_pattern/
└── src/main/java/com/examSystem/
    ├── builder/                        # Module 1 — Builder Pattern
    │   └── ExamConfiguration.java      # Product + static inner Builder
    ├── source/                         # Module 2 — Question Sourcing (Strategy / IoC)
    │   ├── QuestionSource.java
    │   ├── BankQuestionSource.java
    │   └── FakerQuestionSource.java
    ├── abstractfactory/                # Module 3 — Abstract Factory (Question Families)
    │   ├── Question.java
    │   ├── QuestionRenderer.java
    │   ├── QuestionEvaluator.java
    │   ├── QuestionFactory.java
    │   ├── mcq/
    │   ├── essay/
    │   ├── truefalse/
    │   └── programming/
    ├── factory/                        # Module 4 — Factory Method (Exam Types)
    │   ├── Exam.java
    │   ├── AbstractExam.java           # Shared exam logic (takeExam, printQuestions)
    │   ├── ExamFactory.java
    │   ├── PracticeQuiz.java / PracticeQuizFactory.java
    │   ├── MidtermExam.java  / MidtermExamFactory.java
    │   └── FinalExam.java    / FinalExamFactory.java
    └── Main.java                       # Module 5 — Orchestration Entry Point
```

---

## Design Patterns Applied

| Pattern | Location | Role |
|---|---|---|
| **Builder** | `builder/ExamConfiguration` | Fluent, step-by-step construction of exam settings via a static inner `Builder` class |
| **Abstract Factory** | `abstractfactory/` | Guarantees matched families of `Question` + `QuestionRenderer` + `QuestionEvaluator` — prevents mismatched components |
| **Factory Method** | `factory/` | `ExamFactory` subclasses delegate the creation of concrete exam types (`PracticeQuiz`, `MidtermExam`, `FinalExam`) |
| **Strategy / IoC** | `source/` | `QuestionSource` can be swapped between `BankQuestionSource` and `FakerQuestionSource` without changing core logic |

---

## How to Run

```bash
# From project root — collect all source files
dir /s /B *.java > sources.txt

# Compile
javac -d out @sources.txt

# Run
java -cp out com.examSystem.Main
```

---

## Sample Console Output

```
Starting Examination System Initialization...

=== Midterm Exam: Object-Oriented Design Patterns ===
Duration: 120 mins
Negative Marking: YES
Proctored: YES
---------------------------------------------------
Q1. What is the capital of France?
  A) London
  B) Berlin
  C) Paris
  D) Madrid

Q2. Explain the difference between Abstract Factory and Factory Method.
  ___________________________________________________
  ___________________________________________________

Q3. The Earth is flat.
  [ ] True
  [ ] False

Q4. Implement a binary search algorithm.
  ```java
  // Write your code here...
  ```

--- Exam Started ---
Q1. Which design pattern ensures a class has only one instance?
  ...
Your answer: B

=== Exam Completed ===
Total Score: 3.25 / 4.0
Result: PASS
```

---

## Scoring Logic

- **Correct answer:** `+1.0` point
- **Wrong answer (with negative marking enabled):** `-0.25` points
- **Pass threshold:** configurable via `ExamConfiguration.Builder.setPassingScore()`

---

## Architecture Notes

The system is designed around strict separation of concerns. Each question family (MCQ, Essay, True/False, Programming) is completely self-contained — its `Question`, `Renderer`, and `Evaluator` are always created together through the same `QuestionFactory`, making it impossible to accidentally pair an `MCQRenderer` with a `TrueFalseQuestion`.

Shared exam behaviour (`takeExam`, `printQuestions`) is centralised in `AbstractExam`, ensuring scoring logic and negative marking are applied consistently regardless of which exam type is used.

---

## Acknowledgements

Architecture diagrams for this project — including the full UML class diagram covering all design pattern relationships — were drafted with the assistance of **Claude** (Anthropic). The architecture, edge case analysis, modularisation improvements, and code review passes throughout the development cycle were also conducted in collaboration with Claude, whose analysis flagged several structural inconsistencies (duplicated logic, missing null guards, incorrect arrow semantics in UML) that were subsequently resolved.

package com.Assignment2;
import java.util.ArrayList;
import java.util.Scanner;
class Question {
    String questionText;
    String correctAnswer;
    ArrayList<String> options;

    public Question(String questionText, String correctAnswer, ArrayList<String> options) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public boolean checkAnswer(String answer) {
        return this.correctAnswer.equals(answer);
    }
}
class User {
    String name;
    int score;

    public User(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        this.score++;
    }

    public void displayScore() {
        System.out.println(name + "'s score: " + score);
    }
}
class Quiz {
    ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz(User user) {
        Scanner sc = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.questionText);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println((i + 1) + ". " + question.options.get(i));
            }
            System.out.print("Enter your answer: ");
            String answer = sc.nextLine();
            if (question.checkAnswer(answer)) {
                user.addScore();
            }
        }
        user.displayScore();
    }
}
public class Online {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C");
        options1.add("C++");
        Question q1 = new Question("Which programming language is used to develop Android apps?", "Java", options1);

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Linux");
        options2.add("MacOS");
        options2.add("Windows");
        options2.add("Android");
        Question q2 = new Question("Which OS is used for most servers?", "Linux", options2);

        
        Quiz quiz = new Quiz();
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

  
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        User user = new User(name);

        
        quiz.takeQuiz(user);
    }
}

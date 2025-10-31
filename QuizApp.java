import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctOption;

    Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();


        questions.add(new Question(
                "What is the size of int in Java?",
                Arrays.asList("1 byte", "2 bytes", "8 bytes", "4 bytes"), 4));

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("super", "this", "extends", "implements"), 3));

        questions.add(new Question(
                "Which of these is not a Java loop?",
                Arrays.asList("repeat", "while", "for", "do-while"), 1));

        questions.add(new Question(
                "Which collection allows unique elements only?",
                Arrays.asList("List", "Map", "Set", "Queue"), 3));

        questions.add(new Question(
                "Which method is used to start a thread in Java?",
                Arrays.asList("execute()", "start()", "run()", "init()"), 2));

        int score = 0;

        System.out.println("========== WELCOME TO JAVA QUIZ ==========");
        System.out.println("You have " + questions.size() + " questions. Enter your option number (1-4).\n");

        Collections.shuffle(questions);

        for (Question q : questions) {
            System.out.println(q.question);
            for (int i = 0; i < q.options.size(); i++) {
                System.out.println((i + 1) + ". " + q.options.get(i));
            }

            System.out.print("Your answer: ");
            int answer = 0;

            try {
                answer = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Skipping question.\n");
                sc.next();
                continue;
            }

            if (answer == q.correctOption) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.options.get(q.correctOption - 1) + "\n");
            }
        }

        System.out.println("========== QUIZ COMPLETED ==========");
        System.out.println("Your Final Score: " + score + "/" + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent! You nailed it!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job, keep practicing!");
        } else {
            System.out.println("Better luck next time!");
        }

        sc.close();
    }

}

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.LineNumberReader;

import javafx.util.Pair;

public class Main {
    public static String name;

    public static void main(String[] args) {
        boolean playAgain = true;
        int n = 0;
        int score = 0;
        File file;
        Scanner scanner = new Scanner(System.in);


        ArrayList<String> ListQuestions = new ArrayList<>();
        ArrayList<String> ListAnswers = new ArrayList<>();
        ArrayList<String> ListChoices = new ArrayList<>();

        while (playAgain) {
            file = getQuestionFile();
            try {
                LineNumberReader lineReader = new LineNumberReader(new FileReader(file));
                String lineText;
                while ((lineText = lineReader.readLine()) != null) {
                    int lineNumber = lineReader.getLineNumber();
                    if (lineNumber % 2 == 1) {
                        ListQuestions.add(lineText);
                        System.out.println(lineText);
                        String choice = scanner.nextLine();
                        ListChoices.add(choice);
                    } else if (lineNumber % 2 == 0) {
                        ListAnswers.add(lineText);
                    }
                }
                lineReader.close();
            } catch (Exception e) {
            }

            while (n < ListQuestions.size()) {
                Pair<String, String> p1 = new Pair<>(ListQuestions.get(n), ListAnswers.get(n));
                Pair<String, String> p2 = new Pair<>(ListQuestions.get(n), ListChoices.get(n));
                if (p1.equals(p2)) {
                    score++;

                }
                n++;
            }
            System.out.println("Hi " + name + "! Your final score is " + score + ".");
            if (score >= 3) {
                Picture picture = new Picture();
                Picture.picture();
            }
            if (score <= 2) {
                Face face = new Face(30, 30);
                face.draw();
            }


            System.out.println("Would you like to play again? Type true to try again, type false to exit game.");

            boolean badInput = true;
            Scanner play = new Scanner(System.in);
            while (badInput) {
                try {
                    playAgain = play.nextBoolean();
                    badInput = false;
                } catch (Exception e) {
                    System.out.println("Please type true or false for your answer.");
                    play.nextLine();
                }
            }

        }
        System.out.println("Thanks for playing!");
        System.exit(0);


    }

    public static File getQuestionFile() {
        Scanner in = new Scanner(System.in);
        File file = null;

        while (file == null) {
            System.out.println("Welcome to our Harry Potter quiz! \nEach quiz has a series of True/False questions. You will answer by typing either true or false.");
            System.out.println("Please choose a character: Harry, Ron or Hermione.");
            name = in.nextLine();
            try {
                file = new File(name + ".txt");
                if (!file.exists()) {
                    file = null;
                    System.err.println("Problem locating file. Please choose a character: Harry, Ron, or Hermione.");
                }
            } catch (Exception e) {
                continue;
            }
        }
        return file;
    }
}
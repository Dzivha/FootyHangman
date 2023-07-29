import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Hangman by Zero\n");
        File dictionary = new File("footballers.txt");

        Scanner sc = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }
        String hiddenText = words.get((int) (Math.random() * words.size()));

        char[] textArray = hiddenText.toCharArray();

        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;
        while (finished == false) {
            System.out.println("**************************");

            String letter = input.next();

            // check for valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Input error");
                letter = input.next();
            }
            // check if letter is in word
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;

                }
            }

            if (!found) {
                lives--;
                System.out.println("Wrong letter");
            }

            boolean done = true;
            for (int i = 0; i < myAnswers.length; i++) {
                if (textArray[i] == ' ') {
                    myAnswers[i] = textArray[i];
                    System.out.print(" ");
                }
                if (Character.isDigit(textArray[i])) {
                    myAnswers[i] = textArray[i];
                }
                if (myAnswers[i] == '?') {
                    System.out.print("_");
                    done = false;
                } else {
                    System.out.print("" + myAnswers[i]);
                }
            }
            System.out.println("\n" + "lives left: " + lives);
            drawHangman(lives);

            // check if game ends
            if (done) {
                System.out.println("Congratulations, you won!");
                finished = true;
            }
            if (lives <= 0) {
                System.out.println(
                        "Game over! The correct answer was: " + hiddenText + "\n" + "Get your footy knowledge up.");
                finished = true;
            }
        }

    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
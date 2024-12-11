
import java.util.Scanner;

public class Hangman {
    private final String word = "porkchop";
    private int score = 0;
    private int guessesLeft = 7;
    private StringBuilder gallows;

    public Hangman(String word) {
        System.out.println("To play, guess a letter to try to guess the word. " +
                "Every time you choose an incorrect letter another" +
                "body part appears on the gallows. If you guess the " +
                "word before you're hung, you win :-) " +
                "If you get hung you lose :-( ");

        // Make gallows with underscores for each character in the word
        gallows = new StringBuilder("_".repeat(word.length()));  // Initialize gallows as underscores

        //drawing gallows, with custom size based on OG word
        System.out.print(
                "|-----|-\n" +
                        "| \n" +
                        "| \n" +
                        "| \n" +
                        "| \n" +
                        "|");
        System.out.println(gallows);

        //logic
        Scanner scanner = new Scanner(System.in);
        while (guessesLeft > 0 && gallows.indexOf("_") != -1) {
            System.out.print("start guessing here: ");
            char letter = scanner.next().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (letter == word.charAt(i) && gallows.charAt(i) == '_') {
                    gallows.setCharAt(i, letter);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                score++;
                System.out.println("good guess! Next guess: ");
                guessesLeft--;
            } else {
                guessesLeft--;
                System.out.println("Nope.. next guess: ");
            }

            System.out.println(gallows);
            System.out.println("guesses left: " + guessesLeft);
        }
        if (gallows.indexOf("_") == -1) {
            System.out.println("You WIN");
        } else {
            System.out.println("You LOSE");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Hangman("porkchop");
    }
}

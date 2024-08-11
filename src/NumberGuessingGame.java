import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    // Game panel dimensions
    int boardWidth = 600;
    int boardLength = 600; 

    JFrame frame = new JFrame("Number Guessing Game");
    JTextField guessField = new JTextField();
    JLabel messageLabel = new JLabel();
    JLabel attemptsLabel = new JLabel();
    JLabel roundLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JButton submitButton = new JButton();

    Random random = new Random();
    private int lowerBound = 1;
    private int upperBound = 100;
    private int maxAttempts = 7;
    private int totalRounds = 5;
    private int currentRound = 1;
    private int attemptsLeft;
    private int targetNumber;
    private int totalScore = 0;

    public NumberGuessingGame() {
        random = new Random();

        // Set up the main frame properties
        frame.setSize(boardWidth, boardLength);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        // Set up the round label
        roundLabel = new JLabel("Round: " + currentRound + "/" + totalRounds, SwingConstants.CENTER);
        frame.add(roundLabel);

        // Set up the message label
        messageLabel = new JLabel("Guess the number between " + lowerBound + " and " + upperBound, SwingConstants.CENTER);
        frame.add(messageLabel);

        // Set up the guess field
        guessField = new JTextField();
        frame.add(guessField);

        // Set up the attempts label
        attemptsLabel = new JLabel("Attempts left: " + maxAttempts, SwingConstants.CENTER);
        frame.add(attemptsLabel);

        // Set up the score label
        scoreLabel = new JLabel("Total Score: " + totalScore, SwingConstants.CENTER);
        frame.add(scoreLabel);

        // Set up the submit button
        submitButton = new JButton("Submit Guess");
        frame.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        resetGame();
        frame.setVisible(true);
    }

    private void resetGame() {
        attemptsLeft = maxAttempts;
        targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        guessField.setText("");
        updateLabels();
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());

            if (guess == targetNumber) {
                int roundScore = attemptsLeft * 10;
                totalScore += roundScore;
                messageLabel.setText("Congratulations! Correct. You scored " + roundScore + " points.");
                scoreLabel.setText("Total Score: " + totalScore);
                nextRound();
            } else if (guess < targetNumber) {
                messageLabel.setText("Try a higher number.");
                attemptsLeft--;
            } else {
                messageLabel.setText("Try a lower number.");
                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                messageLabel.setText("No attempts left. The correct number was " + targetNumber);
                nextRound();
            }

            updateLabels();
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    private void nextRound() {
        if (currentRound < totalRounds) {
            currentRound++;
            resetGame();
        } else {
            messageLabel.setText("Game Over! Your total score is: " + totalScore);
            submitButton.setEnabled(false);
        }
    }

    private void updateLabels() {
        roundLabel.setText("Round: " + currentRound + "/" + totalRounds);
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
    }
}

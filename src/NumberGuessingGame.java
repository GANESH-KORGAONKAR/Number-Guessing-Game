import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    // Game panel dimensions
    int boardWidth = 500;
    int boardLength = 500; 

    JFrame frame = new JFrame("Number Guessing Game"); // Main game window
    JTextField guessField = new JTextField(); // Field for user to input their guess
    JLabel messageLabel = new JLabel(); // Label to display messages to the user
    JLabel attemptsLabel = new JLabel(); // Label to display remaining attempts
    JLabel roundLabel = new JLabel(); // Label to display the current round
    JLabel scoreLabel = new JLabel(); // Label to display the total score
    JButton submitButton = new JButton(); // Button to submit the user's guess

    Random random = new Random(); // Random number generator
    private int lowerBound = 1; // Lower bound of the guessing range
    private int upperBound = 100; // Upper bound of the guessing range
    private int maxAttempts = 7; // Maximum number of attempts per round
    private int totalRounds = 5; // Total number of rounds in the game
    private int currentRound = 1; // Current round number
    private int attemptsLeft; // Remaining attempts in the current round
    private int targetNumber; // The correct number the user is trying to guess
    private int totalScore = 0; // Total score accumulated across rounds

    public NumberGuessingGame() {
        random = new Random(); // Initialize random number generator

        // Set up the main frame properties
        frame.setSize(boardWidth, boardLength); // Set the size of the window
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setResizable(false); // Prevent window resizing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setLayout(new GridLayout(6, 1)); // Set layout to a 6x1 grid

        // Set up the round label
        roundLabel = new JLabel("Round: " + currentRound + "/" + totalRounds, SwingConstants.CENTER);
        roundLabel.setFont(new Font("Serif", Font.BOLD, 28)); // Increase font size and make it bold
        roundLabel.setForeground(Color.BLUE); // Set text color to blue
        frame.add(roundLabel);

        // Set up the message label
        messageLabel = new JLabel("Guess the number between " + lowerBound + " and " + upperBound, SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 22)); // Set font size and style
        messageLabel.setForeground(Color.DARK_GRAY); // Set text color to dark gray
        frame.add(messageLabel);

        // Set up the guess field
        guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER); // Center the input text
        guessField.setFont(new Font("Serif", Font.PLAIN, 22)); // Set font size and style
        guessField.setBackground(Color.LIGHT_GRAY); // Set background color to light gray
        frame.add(guessField);

        // Set up the attempts label
        attemptsLabel = new JLabel("Attempts left: " + maxAttempts, SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Serif", Font.PLAIN, 22)); // Set font size and style
        attemptsLabel.setForeground(Color.RED); // Set text color to red
        frame.add(attemptsLabel);

        // Set up the score label
        scoreLabel = new JLabel("Total Score: " + totalScore, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 22)); // Set font size and style
        scoreLabel.setForeground(Color.BLACK); // Set text color to green
        frame.add(scoreLabel);

        // Set up the submit button with size and color customization
        submitButton = new JButton("Submit Guess");
        submitButton.setFont(new Font("Serif", Font.BOLD, 22)); // Increase font size and make it bold
        submitButton.setBackground(Color.GREEN); // Set background color to GREEN
        submitButton.setForeground(Color.WHITE); // Set text color to white
        submitButton.setPreferredSize(new Dimension(100, 50)); // Set the preferred size of the button
        frame.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleGuess(); // Handle the user's guess when the button is clicked
            }
        });

        resetGame(); // Start the game by resetting the round
        frame.setVisible(true); // Make the window visible
    }

    // Reset the game for a new round
    private void resetGame() {
        attemptsLeft = maxAttempts; // Reset the number of attempts
        targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound; // Generate a new random target number
        guessField.setText(""); // Clear the guess field
        updateLabels(); // Update labels to reflect the new round
    }

    // Handle the user's guess and provide feedback
    private void handleGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText()); // Convert the user's input to an integer

            if (guess == targetNumber) { // If the guess is correct
                int roundScore = attemptsLeft * 10; // Calculate score based on remaining attempts
                totalScore += roundScore; // Add round score to total score
                messageLabel.setText("Congratulations! Correct. You scored " + roundScore + " points.");
                scoreLabel.setText("Total Score: " + totalScore);
                nextRound(); // Move to the next round
            } else if (guess < targetNumber) { // If the guess is too low
                messageLabel.setText("Try a higher number.");
                attemptsLeft--; // Decrease the number of attempts left
            } else { // If the guess is too high
                messageLabel.setText("Try a lower number.");
                attemptsLeft--; // Decrease the number of attempts left
            }

            if (attemptsLeft == 0) { // If no attempts are left
                messageLabel.setText("No attempts left. The correct number was " + targetNumber);
                nextRound(); // Move to the next round
            }

            updateLabels(); // Update labels to reflect the current state
        } catch (NumberFormatException ex) { // Handle non-integer input
            messageLabel.setText("Please enter a valid number.");
        }
    }

    // Move to the next round or end the game if all rounds are completed
    private void nextRound() {
        if (currentRound < totalRounds) { // If there are more rounds left
            currentRound++; // Increment the round counter
            resetGame(); // Reset the game for the next round
        } else { // If all rounds are completed
            messageLabel.setText("Game Over! Your total score is: " + totalScore);
            submitButton.setEnabled(false); // Disable the submit button to end the game
        }
    }

    // Update the labels to show the current round, remaining attempts, and total score
    private void updateLabels() {
        roundLabel.setText("Round: " + currentRound + "/" + totalRounds);
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
    }

    public static void main(String[] args) {
        new NumberGuessingGame(); // Start the game
    }
}

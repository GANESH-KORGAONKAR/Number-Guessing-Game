# Number Guessing Game

Welcome to the Number Guessing Game! This is a graphical Java application that challenges players to guess a randomly generated number within a specific range. The game provides multiple rounds, with each round offering a limited number of attempts to guess the correct number. Players score points based on how quickly they guess the number, with higher scores awarded for fewer attempts.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Game Mechanics](#game-mechanics)
- [Acknowledgements](#acknowledgements)

## Features
- Graphical user interface (GUI) for an interactive experience.
- Configurable range for the guessing numbers.
- Multiple rounds of play with score tracking.
- Feedback on whether the guess was too high, too low, or correct.
- Score calculation based on remaining attempts.
- End-of-game summary displaying the total score.

## Requirements
- Java Development Kit (JDK)
- An IDE or text editor for writing and running Java code (e.g., IntelliJ IDEA, Eclipse, or VS Code)
- Basic knowledge of Java and Swing (for GUI)

## Setup and Installation
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Download or clone the project code to your local machine.
3. Open the code in your preferred IDE or text editor.

## How to Run
1. Navigate to the directory containing the project files.
2. Compile the Java files using the following command:
   ```bash
   javac NumberGuessingGame.java
   ```
3. Run the compiled Java program using the following command:
   ```bash
   java NumberGuessingGame
   ```

## Usage
1. **Start the Game**: Launch the application to begin a new game.
2. **Input Your Guess**: Enter a number in the provided text field and click the "Submit Guess" button.
3. **Receive Feedback**: The game will inform you whether your guess is too high, too low, or correct.
4. **Score Points**: If you guess the number correctly, you'll score points based on the remaining attempts.
5. **Next Round**: The game automatically moves to the next round after a correct guess or if you run out of attempts.
6. **Game Over**: After completing all rounds, the game will display your total score and end the session.

## Game Mechanics
- **Rounds**: The game consists of 5 rounds.
- **Guessing Range**: You need to guess a number between 1 and 100.
- **Attempts**: Each round provides you with 7 attempts to guess the correct number.
- **Scoring**: Points are awarded based on how quickly you guess the correct number, with more points given for fewer attempts.

### Classes and Methods

#### NumberGuessingGame
- **NumberGuessingGame()**: Constructor that initializes the game window and components.
- **resetGame()**: Resets the game state for a new round.
- **handleGuess()**: Handles the player's guess, providing feedback and updating the game state.
- **nextRound()**: Advances the game to the next round or ends the game if all rounds are completed.
- **updateLabels()**: Updates the GUI labels to reflect the current game state.

## Acknowledgements
This project was developed as a learning exercise for Java Swing and basic game logic. It is an updated version of my project, which is part of the Oasis Infobyte Internship Program. Special thanks to the Java and Swing communities for their extensive documentation and tutorials, which were invaluable in the creation of this game. Additionally, I received some help adding comments and refining the code from ChatGPT.

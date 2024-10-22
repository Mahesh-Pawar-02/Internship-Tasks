import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame extends JFrame {
    private int randomNumber;
    private int attempts = 0;
    private int score = 0;
    private final int maxAttempts = 10;

    private JTextField guessInput;
    private JLabel messageLabel, scoreLabel, attemptsLabel;

    public NumberGuessingGame() {
        // Generate random number
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        // Setup GUI components
        setTitle("Number Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        // Prompt for number input
        JLabel promptLabel = new JLabel("Guess a number between 1 and 100:");
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(promptLabel);

        // Input field for user guesses
        guessInput = new JTextField(SwingConstants.CENTER);
        guessInput.setFont(new Font("Arial", Font.PLAIN, 40));
        add(guessInput);

        // Button to submit guess
        JButton guessButton = new JButton("Submit Guess");
        guessButton.setBackground(Color.GREEN);
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));
        guessButton.addActionListener(new GuessButtonListener());
        add(guessButton);

        // Message label to provide feedback
        messageLabel = new JLabel("Enter a number to start playing!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(messageLabel);

        // Score label
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(scoreLabel);

        // Attempts label
        attemptsLabel = new JLabel("Attempts: 0", SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(attemptsLabel);

        // Make the window visible
        setVisible(true);
    }

    // Action Listener for the guess button
    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = guessInput.getText();
            try {
                int guess = Integer.parseInt(userInput);
                attempts++;
                attemptsLabel.setText("Attempts: " + attempts);

                if (attempts >= maxAttempts) {
                    messageLabel.setText("Game over! You've exceeded the max attempts.");
                    resetGame();
                } else if (guess < randomNumber) {
                    messageLabel.setText("Too low! Try again.");
                } else if (guess > randomNumber) {
                    messageLabel.setText("Too high! Try again.");
                } else {
                    messageLabel.setText("Correct! You guessed the number.");
                    score++;
                    scoreLabel.setText("Score: " + score);
                    resetGame(); // Reset game after correct guess
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input. Enter a valid number.");
            }
            guessInput.setText(""); // Clear input field
        }
    }

    // Reset the game after winning or max attempts
    private void resetGame() {
        randomNumber = new Random().nextInt(100) + 1; // New random number
        attempts = 0; // Reset attempts
        attemptsLabel.setText("Attempts: 0"); // Update attempts label
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGame::new);
    }
}

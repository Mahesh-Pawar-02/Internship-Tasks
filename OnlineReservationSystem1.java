import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineReservationSystem1 extends JFrame {

    // Constructor for setting up the GUI
    public OnlineReservationSystem1() {
        // Set the title of the window
        setTitle("Online Reservation System");

        // Create the Login Form first
        showLoginForm();
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the window size
        setSize(400, 300);
        
        // Make the window visible
        setVisible(true);
    }

    // Login Form
    private void showLoginForm() {
        // Clear previous content
        getContentPane().removeAll();
        
        // Create components
        JLabel loginLabel = new JLabel("Login Form", JLabel.CENTER);
        JLabel loginIdLabel = new JLabel("Login ID:");
        JTextField loginIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        // Add Action Listener for the Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loginId = loginIdField.getText();
                String password = new String(passwordField.getPassword());

                // Check for valid credentials (hardcoded for now)
                if (loginId.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    showReservationForm(); // Open Reservation Form
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login ID or Password.");
                }
            }
        });

        // Create Layout for Login Form
        setLayout(new GridLayout(5, 2));
        add(loginLabel);
        add(new JLabel(""));  // Empty label for spacing
        add(loginIdLabel);
        add(loginIdField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
    }

    // Reservation Form
    private void showReservationForm() {
        // Clear previous content
        getContentPane().removeAll();

        // Create components
        JLabel reservationLabel = new JLabel("Reservation Form", JLabel.CENTER);
        JLabel trainNumberLabel = new JLabel("Train Number:");
        JTextField trainNumberField = new JTextField();
        JLabel trainNameLabel = new JLabel("Train Name:");
        JTextField trainNameField = new JTextField();
        JLabel fromLabel = new JLabel("From:");
        JTextField fromField = new JTextField();
        JLabel toLabel = new JLabel("To:");
        JTextField toField = new JTextField();
        JButton bookButton = new JButton("Book Ticket");
        JButton cancelButton = new JButton("Go to Cancellation");

        // Add Action Listener for Book Button
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String trainNumber = trainNumberField.getText();
                String trainName = trainNameField.getText();
                String from = fromField.getText();
                String to = toField.getText();
                // Show confirmation
                JOptionPane.showMessageDialog(null, "Ticket for " + trainName + " (" + trainNumber + ") from " + from + " to " + to + " booked successfully!");
            }
        });

        // Add Action Listener for Cancel Button (to switch to Cancellation Form)
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCancellationForm();
            }
        });

        // Create Layout for Reservation Form
        setLayout(new GridLayout(7, 2));
        add(reservationLabel);
        add(new JLabel(""));  // Empty label for spacing
        add(trainNumberLabel);
        add(trainNumberField);
        add(trainNameLabel);
        add(trainNameField);
        add(fromLabel);
        add(fromField);
        add(toLabel);
        add(toField);
        add(bookButton);
        add(cancelButton);

        // Refresh the frame
        revalidate();
        repaint();
    }

    // Cancellation Form
    private void showCancellationForm() {
        // Clear previous content
        getContentPane().removeAll();

        // Create components
        JLabel cancelLabel = new JLabel("Cancellation Form", JLabel.CENTER);
        JLabel pnrLabel = new JLabel("PNR Number:");
        JTextField pnrField = new JTextField();
        JButton cancelButton = new JButton("Cancel Ticket");

        // Add Action Listener for Cancel Button
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pnrNumber = pnrField.getText();
                // Show confirmation
                JOptionPane.showMessageDialog(null, "Ticket with PNR " + pnrNumber + " has been cancelled successfully!");
            }
        });

        // Create Layout for Cancellation Form
        setLayout(new GridLayout(3, 2));
        add(cancelLabel);
        add(new JLabel(""));  // Empty label for spacing
        add(pnrLabel);
        add(pnrField);
        add(cancelButton);

        // Refresh the frame
        revalidate();
        repaint();
    }

    // Main method
    public static void main(String[] args) {
        // Create an instance of the OnlineReservationSystem class
        new OnlineReservationSystem1();
    }
}

import javax.swing.*;
import java.awt.*;

public class RestrictedReservationSystem extends JFrame {
    
    private boolean isLoggedIn = false;  // Session flag to track login status
    private JTabbedPane tabbedPane;      // The Tabbed Pane holding the forms
    
    // Constructor for setting up the improved GUI
    public RestrictedReservationSystem() {
        // Set the title and basic window properties
        setTitle("Online Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        
        // Create a Tabbed Pane for better navigation
        tabbedPane = new JTabbedPane();
        
        // Add Tabs for Login, Reservation, and Cancellation
        tabbedPane.addTab("Login", createLoginForm());
        tabbedPane.addTab("Reservation", createReservationForm());
        tabbedPane.addTab("Cancellation", createCancellationForm());
        
        // Initially disable the Reservation and Cancellation tabs
        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
        
        // Add the Tabbed Pane to the frame
        add(tabbedPane);
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // Method to create the Login Form with improved UI
    private JPanel createLoginForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Login to Reservation System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 128, 255));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel loginIdLabel = new JLabel("Login ID:");
        loginIdLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(loginIdLabel, gbc);
        
        gbc.gridx = 1;
        JTextField loginIdField = new JTextField(15);
        panel.add(loginIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 128, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Login Action Listener
        loginButton.addActionListener(e -> {
            String loginId = loginIdField.getText();
            String password = new String(passwordField.getPassword());
            if (loginId.equals("admin") && password.equals("12345")) {
                JOptionPane.showMessageDialog(panel, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                isLoggedIn = true;  // Set session flag to true
                enableTabs();       // Enable other tabs after login
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        panel.add(loginButton, gbc);
        return panel;
    }
    
    // Method to enable the Reservation and Cancellation tabs after successful login
    private void enableTabs() {
        if (isLoggedIn) {
            tabbedPane.setEnabledAt(1, true);  // Enable Reservation tab
            tabbedPane.setEnabledAt(2, true);  // Enable Cancellation tab
        }
    }
    
    // Method to create the Reservation Form with improved UI
    private JPanel createReservationForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Reservation Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(34, 139, 34));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel trainNumberLabel = new JLabel("Train Number:");
        trainNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(trainNumberLabel, gbc);
        
        gbc.gridx = 1;
        JTextField trainNumberField = new JTextField(15);
        panel.add(trainNumberField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel trainNameLabel = new JLabel("Train Name:");
        trainNameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(trainNameLabel, gbc);
        
        gbc.gridx = 1;
        JTextField trainNameField = new JTextField(15);
        panel.add(trainNameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(fromLabel, gbc);
        
        gbc.gridx = 1;
        JTextField fromField = new JTextField(15);
        panel.add(fromField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel toLabel = new JLabel("To:");
        toLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(toLabel, gbc);
        
        gbc.gridx = 1;
        JTextField toField = new JTextField(15);
        panel.add(toField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        JButton bookButton = new JButton("Book Ticket");
        bookButton.setBackground(new Color(34, 139, 34));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Booking Action Listener
        bookButton.addActionListener(e -> {
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String from = fromField.getText();
            String to = toField.getText();
            JOptionPane.showMessageDialog(panel, "Ticket for " + trainName + " (" + trainNumber + ") booked successfully!", "Booking Confirmed", JOptionPane.INFORMATION_MESSAGE);
        });
        
        panel.add(bookButton, gbc);
        return panel;
    }
    
    // Method to create the Cancellation Form with improved UI
    private JPanel createCancellationForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Cancellation Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(255, 69, 0));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        JLabel pnrLabel = new JLabel("PNR Number:");
        pnrLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(pnrLabel, gbc);
        
        gbc.gridx = 1;
        JTextField pnrField = new JTextField(15);
        panel.add(pnrField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Cancellation Action Listener
        cancelButton.addActionListener(e -> {
            String pnrNumber = pnrField.getText();
            JOptionPane.showMessageDialog(panel, "Ticket with PNR " + pnrNumber + " cancelled successfully!", "Cancellation Confirmed", JOptionPane.INFORMATION_MESSAGE);
        });
        
        panel.add(cancelButton, gbc);
        return panel;
    }
    
    // Main method to run the GUI application
    public static void main(String[] args) {
        new RestrictedReservationSystem();
    }
}

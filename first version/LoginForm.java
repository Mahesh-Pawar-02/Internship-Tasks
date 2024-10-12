import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    private String validUser = "admin";
    private String validPassword = "password";

    public LoginForm() {
        setTitle("Login - Online Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(45, 45, 45));
        GridBagConstraints gbc = new GridBagConstraints();

        // Create components
        JLabel title = new JLabel("Login to Your Account");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        // Styling buttons
        loginButton.setBackground(new Color(60, 179, 113));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        // Adding components to the panel
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridy++;
        panel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(loginButton, gbc);

        gbc.gridy++;
        panel.add(messageLabel, gbc);

        // Add panel to the frame
        add(panel);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(validUser) && password.equals(validPassword)) {
                    messageLabel.setText("Login successful!");
                    dispose();
                    new ReservationForm();
                } else {
                    messageLabel.setText("Invalid credentials, please try again.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

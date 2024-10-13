// LoginPanel.java
import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private Reservation reservation;

    public LoginPanel(Reservation reservation) {
        this.reservation = reservation;
        createLoginForm();
    }

    private void createLoginForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginIdLabel = new JLabel("Login ID:");
        gbc.gridx = 0; gbc.gridy = 0;
        add(loginIdLabel, gbc);

        JTextField loginIdField = new JTextField(15);
        gbc.gridx = 1;
        add(loginIdField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            if (loginIdField.getText().equals("admin") && new String(passwordField.getPassword()).equals("12345")) {
                reservation.enableTabs();
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(loginButton, gbc);
    }
}

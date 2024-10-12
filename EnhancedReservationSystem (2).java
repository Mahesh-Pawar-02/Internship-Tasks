import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnhancedReservationSystem extends JFrame {

    private boolean isLoggedIn = false;
    private JTabbedPane tabbedPane;
    private ArrayList<Ticket> bookedTickets;  // To store booked tickets with PNR
    private JButton loginLogoutButton; // Button to toggle login/logout

    // Ticket class to store details with PNR
    class Ticket {
        String pnr;
        String trainNumber;
        String trainName;
        String from;
        String to;

        public Ticket(String pnr, String trainNumber, String trainName, String from, String to) {
            this.pnr = pnr;
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "PNR: " + pnr + ", Train: " + trainName + " (" + trainNumber + "), From: " + from + " To: " + to;
        }
    }

    public EnhancedReservationSystem() {
        setTitle("Enhanced Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        bookedTickets = new ArrayList<>();
        tabbedPane = new JTabbedPane();

        // Add Tabs
        tabbedPane.addTab("Login", createLoginForm());
        tabbedPane.addTab("Reservation", createReservationForm());
        tabbedPane.addTab("Cancellation", createCancellationForm());
        tabbedPane.addTab("View Booked Tickets", createViewBookedTicketsPanel());

        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
        tabbedPane.setEnabledAt(3, false);

        // Create and add login/logout button
        loginLogoutButton = new JButton("Login");
        loginLogoutButton.addActionListener(e -> toggleLoginLogout());
        add(loginLogoutButton, BorderLayout.NORTH);

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void toggleLoginLogout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            loginLogoutButton.setText("Login");
            disableTabs();
            JOptionPane.showMessageDialog(this, "Logged out successfully!");
        } else {
            // Open login form dialog
            JPanel loginPanel = createLoginForm();
            int option = JOptionPane.showConfirmDialog(this, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                JTextField loginIdField = (JTextField) loginPanel.getComponent(1);
                JPasswordField passwordField = (JPasswordField) loginPanel.getComponent(3);
                if (loginIdField.getText().equals("admin") && new String(passwordField.getPassword()).equals("12345")) {
                    isLoggedIn = true;
                    loginLogoutButton.setText("Logout");
                    enableTabs();
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials");
                }
            }
        }
    }

    private void enableTabs() {
        tabbedPane.setEnabledAt(1, true); // Reservation
        tabbedPane.setEnabledAt(2, true); // Cancellation
        tabbedPane.setEnabledAt(3, true); // View Booked Tickets
    }

    private void disableTabs() {
        tabbedPane.setEnabledAt(1, false); // Reservation
        tabbedPane.setEnabledAt(2, false); // Cancellation
        tabbedPane.setEnabledAt(3, false); // View Booked Tickets
    }

    private JPanel createLoginForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginIdLabel = new JLabel("Login ID:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(loginIdLabel, gbc);

        JTextField loginIdField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(loginIdField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        return panel;
    }

    private JPanel createReservationForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel trainNumberLabel = new JLabel("Train Number:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(trainNumberLabel, gbc);

        JTextField trainNumberField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(trainNumberField, gbc);

        JLabel trainNameLabel = new JLabel("Train Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(trainNameLabel, gbc);

        JTextField trainNameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(trainNameField, gbc);

        JLabel fromLabel = new JLabel("From:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(fromLabel, gbc);

        JTextField fromField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(fromField, gbc);

        JLabel toLabel = new JLabel("To:");
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(toLabel, gbc);

        JTextField toField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(toField, gbc);

        JButton bookButton = new JButton("Book Ticket");
        bookButton.addActionListener(e -> {
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String from = fromField.getText();
            String to = toField.getText();

            if (!trainNumber.isEmpty() && !trainName.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                String pnr = generatePNR();
                bookedTickets.add(new Ticket(pnr, trainNumber, trainName, from, to));
                JOptionPane.showMessageDialog(panel, "Ticket booked successfully! PNR: " + pnr);
            } else {
                JOptionPane.showMessageDialog(panel, "All fields are required");
            }
        });

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(bookButton, gbc);
        return panel;
    }

    // Method to generate a random 10-digit PNR number
    private String generatePNR() {
        Random random = new Random();
        long pnr = 1000000000L + random.nextLong(9000000000L);
        return String.valueOf(pnr);
    }

    private JPanel createCancellationForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel pnrLabel = new JLabel("PNR Number:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(pnrLabel, gbc);

        JTextField pnrField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(pnrField, gbc);

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.addActionListener(e -> {
            String pnr = pnrField.getText();
            boolean ticketFound = false;

            for (Ticket ticket : bookedTickets) {
                if (ticket.pnr.equals(pnr)) {
                    bookedTickets.remove(ticket);
                    JOptionPane.showMessageDialog(panel, "Ticket with PNR " + pnr + " cancelled successfully!");
                    ticketFound = true;
                    break;
                }
            }

            if (!ticketFound) {
                JOptionPane.showMessageDialog(panel, "Ticket with PNR " + pnr + " not found");
            }
        });

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panel.add(cancelButton, gbc);
        return panel;
    }

    // Panel to view booked tickets
    private JPanel createViewBookedTicketsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton viewTicketsButton = new JButton("View Booked Tickets");
        viewTicketsButton.addActionListener(e -> {
            JDialog bookedDialog = new JDialog(this, "Booked Tickets", true);
            bookedDialog.setSize(400, 300);
            bookedDialog.setLocationRelativeTo(panel);

            JTextArea bookedTextArea = new JTextArea();
            bookedTextArea.setEditable(false);

            for (Ticket ticket : bookedTickets) {
                bookedTextArea.append(ticket.toString() + "\n");
            }

            bookedDialog.add(new JScrollPane(bookedTextArea));
            bookedDialog.setVisible(true);
        });

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(viewTicketsButton, gbc);

        JButton viewPNRButton = new JButton("View All PNR Numbers");
        viewPNRButton.addActionListener(e -> {
            JDialog pnrDialog = new JDialog(this, "PNR Numbers", true);
            pnrDialog.setSize(300, 200);
            pnrDialog.setLocationRelativeTo(panel);

            JTextArea pnrTextArea = new JTextArea();
            pnrTextArea.setEditable(false);

            for (Ticket ticket : bookedTickets) {
                pnrTextArea.append(ticket.pnr + "\n");
            }

            pnrDialog.add(new JScrollPane(pnrTextArea));
            pnrDialog.setVisible(true);
        });

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        panel.add(viewPNRButton, gbc);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EnhancedReservationSystem::new);
    }
}

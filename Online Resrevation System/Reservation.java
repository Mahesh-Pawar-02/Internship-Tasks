// Reservation.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Reservation extends JFrame {

    private boolean isLoggedIn = false;
    private JTabbedPane tabbedPane;
    private ArrayList<Ticket> bookedTickets;  // To store booked tickets with PNR

    public Reservation() {
        setTitle("Online Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        bookedTickets = new ArrayList<>();
        tabbedPane = new JTabbedPane();

        // Add Tabs
        tabbedPane.addTab("Login", new LoginPanel(this));
        tabbedPane.addTab("Reservation", new BookingPanel(bookedTickets));
        tabbedPane.addTab("Cancellation", new CancellationPanel(bookedTickets));
        tabbedPane.addTab("View Booked Tickets", createViewBookedTicketsPanel());

        tabbedPane.setEnabledAt(1, false); // Disable Reservation until logged in
        tabbedPane.setEnabledAt(2, false); // Disable Cancellation until logged in
        tabbedPane.setEnabledAt(3, false); // Disable View Tickets until logged in

        add(tabbedPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void enableTabs() {
        tabbedPane.setEnabledAt(1, true); // Enable Reservation
        tabbedPane.setEnabledAt(2, true); // Enable Cancellation
        tabbedPane.setEnabledAt(3, true); // Enable View Booked Tickets
    }

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

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Reservation::new);
    }
}

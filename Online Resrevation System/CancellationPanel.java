// CancellationPanel.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CancellationPanel extends JPanel {
    private ArrayList<Ticket> bookedTickets;

    public CancellationPanel(ArrayList<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
        createCancellationForm();
    }

    private void createCancellationForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel pnrLabel = new JLabel("PNR Number:");
        gbc.gridx = 0; gbc.gridy = 0;
        add(pnrLabel, gbc);

        JTextField pnrField = new JTextField(15);
        gbc.gridx = 1;
        add(pnrField, gbc);

        JButton cancelButton = new JButton("Cancel Ticket");
        cancelButton.addActionListener(e -> {
            String pnr = pnrField.getText();
            boolean ticketFound = false;

            for (Ticket ticket : bookedTickets) {
                if (ticket.pnr.equals(pnr)) {
                    bookedTickets.remove(ticket);
                    JOptionPane.showMessageDialog(this, "Ticket with PNR " + pnr + " cancelled successfully!");
                    ticketFound = true;
                    break;
                }
            }

            if (!ticketFound) {
                JOptionPane.showMessageDialog(this, "Ticket with PNR " + pnr + " not found");
            }
        });

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        add(cancelButton, gbc);
    }
}

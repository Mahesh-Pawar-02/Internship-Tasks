// BookingPanel.java
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BookingPanel extends JPanel {
    private ArrayList<Ticket> bookedTickets;

    public BookingPanel(ArrayList<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
        createReservationForm();
    }

    private void createReservationForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel trainNumberLabel = new JLabel("Train Number:");
        gbc.gridx = 0; gbc.gridy = 0;
        add(trainNumberLabel, gbc);

        JTextField trainNumberField = new JTextField(15);
        gbc.gridx = 1;
        add(trainNumberField, gbc);

        JLabel trainNameLabel = new JLabel("Train Name:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(trainNameLabel, gbc);

        JTextField trainNameField = new JTextField(15);
        gbc.gridx = 1;
        add(trainNameField, gbc);

        JLabel fromLabel = new JLabel("From:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(fromLabel, gbc);

        JTextField fromField = new JTextField(15);
        gbc.gridx = 1;
        add(fromField, gbc);

        JLabel toLabel = new JLabel("To:");
        gbc.gridx = 0; gbc.gridy = 3;
        add(toLabel, gbc);

        JTextField toField = new JTextField(15);
        gbc.gridx = 1;
        add(toField, gbc);

        JButton bookButton = new JButton("Book Ticket");
        bookButton.addActionListener(e -> {
            String trainNumber = trainNumberField.getText();
            String trainName = trainNameField.getText();
            String from = fromField.getText();
            String to = toField.getText();

            if (!trainNumber.isEmpty() && !trainName.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                String pnr = generatePNR();
                bookedTickets.add(new Ticket(pnr, trainNumber, trainName, from, to));
                JOptionPane.showMessageDialog(this, "Ticket booked successfully! PNR: " + pnr);
            } else {
                JOptionPane.showMessageDialog(this, "All fields are required");
            }
        });

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(bookButton, gbc);
    }

    private String generatePNR() {
        Random random = new Random();
        long pnr = 1000000000L + random.nextLong(9000000000L);
        return String.valueOf(pnr);
    }
}

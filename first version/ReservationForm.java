import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReservationForm extends JFrame {
    private JTextField nameField, trainNumberField, fromField, toField, dateField;
    private JComboBox<String> classTypeBox;
    private JButton bookButton, showReservationsButton;
    private JTextArea reservationArea;
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private static int pnrCounter = 1000;

    public ReservationForm() {
        setTitle("Ticket Reservation - Online Reservation System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel with background color
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(30, 144, 255));
        GridBagConstraints gbc = new GridBagConstraints();

        // Title
        JLabel title = new JLabel("Train Reservation Form");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        // Fields
        nameField = new JTextField(15);
        trainNumberField = new JTextField(10);
        fromField = new JTextField(10);
        toField = new JTextField(10);
        dateField = new JTextField(10);

        // Combo box for class type
        classTypeBox = new JComboBox<>(new String[]{"AC", "Non-AC"});

        // Buttons
        bookButton = new JButton("Book Ticket");
        showReservationsButton = new JButton("Show Reservations");
        reservationArea = new JTextArea(10, 40);
        reservationArea.setEditable(false);
        reservationArea.setBackground(new Color(240, 255, 240));

        // Styling buttons
        bookButton.setBackground(new Color(60, 179, 113));
        bookButton.setForeground(Color.WHITE);
        showReservationsButton.setBackground(new Color(255, 165, 0));
        showReservationsButton.setForeground(Color.WHITE);

        // Adding components to the panel
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridy++;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Train Number:"), gbc);
        gbc.gridx = 1;
        panel.add(trainNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("From:"), gbc);
        gbc.gridx = 1;
        panel.add(fromField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("To:"), gbc);
        gbc.gridx = 1;
        panel.add(toField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Class Type:"), gbc);
        gbc.gridx = 1;
        panel.add(classTypeBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Date of Journey:"), gbc);
        gbc.gridx = 1;
        panel.add(dateField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        panel.add(bookButton, gbc);

        gbc.gridy++;
        panel.add(showReservationsButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(reservationArea), gbc);

        add(panel);

        // Booking action
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String trainNumber = trainNumberField.getText();
                String from = fromField.getText();
                String to = toField.getText();
                String classType = classTypeBox.getSelectedItem().toString();
                String dateOfJourney = dateField.getText();
                String PNR = "PNR" + pnrCounter++;

                Reservation reservation = new Reservation(name, trainNumber, classType, from, to, dateOfJourney, PNR);
                reservations.add(reservation);

                reservationArea.append("Booked: " + reservation.toString() + "\n");
                clearFields();
            }
        });

        // Show reservations
        showReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservationArea.setText("");
                for (Reservation res : reservations) {
                    reservationArea.append(res.toString() + "\n");
                }
            }
        });

        setVisible(true);
    }

    private void clearFields() {
        nameField.setText("");
        trainNumberField.setText("");
        fromField.setText("");
        toField.setText("");
        dateField.setText("");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CancellationForm extends JFrame {
    private JTextField pnrField;
    private JButton cancelButton;
    private JTextArea messageArea;
    private ArrayList<Reservation> reservations;

    public CancellationForm(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
        setTitle("Cancel Ticket");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(72, 61, 139));
        GridBagConstraints gbc = new GridBagConstraints();

        pnrField = new JTextField(15);
        cancelButton = new JButton("Cancel Ticket");
        messageArea = new JTextArea(5, 30);
        messageArea.setEditable(false);
        messageArea.setBackground(new Color(240, 248, 255));

        cancelButton.setBackground(new Color(255, 69, 0));
        cancelButton.setForeground(Color.WHITE);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Enter PNR to Cancel:"),

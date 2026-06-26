package ui;

import java.awt.*;
import javax.swing.*;
import service.MedicineService;

public class AddMedicineFrame extends JFrame {

    private JTextField nameField;
    private JTextField dosageField;
    private JTextField timeField;
    private JTextField quantityField;
    private JTextField expiryField;

    private JButton saveButton;

    public AddMedicineFrame() {

        initializeUI();
    }

    private void initializeUI() {

        setTitle("Add Medicine");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Medicine Name"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Dosage"));
        dosageField = new JTextField();
        add(dosageField);

        add(new JLabel("Time"));
        timeField = new JTextField();
        add(timeField);

        add(new JLabel("Quantity"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Expiry Date"));
        expiryField = new JTextField();
        add(expiryField);

        saveButton = new JButton("Save Medicine");

        add(new JLabel());
        add(saveButton);

        registerEvents();

        setVisible(true);
    }

    private void registerEvents() {

        saveButton.addActionListener(e -> {

            try {

                String name = nameField.getText();

                String dosage = dosageField.getText();

                String time = timeField.getText();

                int quantity =
                        Integer.parseInt(quantityField.getText());

                String expiry =
                        expiryField.getText();

                MedicineService
        .getInstance()
        .addMedicine(
                name,
                dosage,
                time,
                quantity,
                expiry
        );

                JOptionPane.showMessageDialog(
                        this,
                        "Medicine Added Successfully!"
                );

                clearFields();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Input"
                );
            }

        });
    }

    private void clearFields() {

        nameField.setText("");
        dosageField.setText("");
        timeField.setText("");
        quantityField.setText("");
        expiryField.setText("");
    }
}
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

        // 1. Create a main panel
        JPanel mainPanel = new JPanel();
        
        // 2. Set your GridLayout on this panel instead of the frame
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        // 3. Add padding (Top, Left, Bottom, Right) - 30 pixels on the left/right
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // 4. Add your components to the mainPanel
        mainPanel.add(new JLabel("Medicine Name"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Dosage"));
        dosageField = new JTextField();
        mainPanel.add(dosageField);

        mainPanel.add(new JLabel("Time"));
        timeField = new JTextField();
        mainPanel.add(timeField);

        mainPanel.add(new JLabel("Quantity"));
        quantityField = new JTextField();
        mainPanel.add(quantityField);

        mainPanel.add(new JLabel("Expiry Date"));
        expiryField = new JTextField();
        mainPanel.add(expiryField);

        saveButton = new JButton("Save Medicine");

        mainPanel.add(new JLabel()); // Empty placeholder
        mainPanel.add(saveButton);

        // 5. Add the padded panel to the JFrame
        add(mainPanel);

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
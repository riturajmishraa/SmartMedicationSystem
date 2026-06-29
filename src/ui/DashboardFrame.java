package ui;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import model.Medicine;
import service.ExpiryService;
import service.LowStockService;
import service.ReminderService;

public class DashboardFrame extends JFrame {

    private JButton addMedicineButton;
    private JButton nextMedicineButton;
    private JButton inventoryButton;
    private JButton lowStockButton;
    private JButton expiryAlertButton;
    private JButton historyButton;
    private JButton exitButton;

    public DashboardFrame() {

        initializeUI();
    }

    private void initializeUI() {
    setTitle("Smart Medication System");

    setSize(1000, 700);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setResizable(false);

    ImageIcon appIcon =
            new ImageIcon("assets/logo.jpg");

    setIconImage(appIcon.getImage());



    BackgroundPanel background =
            new BackgroundPanel(
                    "assets/background.jpg"
            );

    background.setLayout(null);

    setContentPane(background);



    Font buttonFont =
            new Font(
                    "Segoe UI",
                    Font.BOLD,
                    18
            );



    addMedicineButton =
            new RoundedButton(
                    "Add Medicine"
            );

    nextMedicineButton =
            new RoundedButton(
                    "Next Medicine"
            );

    inventoryButton =
            new RoundedButton(
                    "Inventory"
            );

    lowStockButton =
            new RoundedButton(
                    "Low Stock Alert"
            );

    expiryAlertButton =
            new RoundedButton(
                    "Expiry Alert"
            );

    historyButton =
            new RoundedButton(
                    "History"
            );

    exitButton =
            new RoundedButton(
                    "Exit"
            );



    JButton[] buttons = {

            addMedicineButton,
            nextMedicineButton,
            inventoryButton,
            lowStockButton,
            expiryAlertButton,
            historyButton,
            exitButton

    };



    for (JButton button : buttons) {

        button.setFont(buttonFont);

        background.add(button);
    }



    addMedicineButton.setBounds(
            120,
            120,
            180,
            70
    );



    nextMedicineButton.setBounds(
            650,
            120,
            180,
            70
    );



    inventoryButton.setBounds(
            120,
            250,
            180,
            70
    );



    lowStockButton.setBounds(
            650,
            250,
            180,
            70
    );



    expiryAlertButton.setBounds(
            120,
            380,
            180,
            70
    );



    historyButton.setBounds(
            650,
            380,
            180,
            70
    );
    exitButton.setBounds(430, 490, 140, 50);

    // 2. Set colors
    exitButton.setBackground(new Color(220, 38, 38));
    exitButton.setForeground(Color.WHITE); 
    try {
        ImageIcon originalIcon = new ImageIcon("assets/exit.png");
        // Scale the icon down to 20x20 pixels so it fits nicely
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
        exitButton.setIcon(new ImageIcon(scaledImage));
        
        // Position the text on the left, and the icon on the right
        exitButton.setHorizontalTextPosition(SwingConstants.LEFT);
        exitButton.setIconTextGap(10); // Adds a nice gap between the word "Exit" and the icon
        
    } catch (Exception e) {
        System.out.println("Could not load exit icon.");
    }



    registerEvents();

    setVisible(true);
}


    private void registerEvents() {

        addMedicineButton.addActionListener(
                e -> new AddMedicineFrame()
        );

        inventoryButton.addActionListener(
                e -> new InventoryFrame()
        );

        historyButton.addActionListener(
                e -> new HistoryFrame()
        );

        nextMedicineButton.addActionListener(e -> {

            Medicine medicine =
                    new ReminderService()
                            .getNextMedicine();

            if (medicine == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "No upcoming medicines scheduled for the rest of today."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,

                    "Next Medicine Due\n\n"

                            + medicine.getName()

                            + "\n"

                            + medicine.getTime()
            );
        });

        lowStockButton.addActionListener(e -> {

            List<Medicine> lowStockMedicines =
                    new LowStockService()
                            .getLowStockMedicines();

            if (lowStockMedicines.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No Low Stock Medicines"
                );

                return;
            }

            StringBuilder message =
                    new StringBuilder();

            message.append(
                    "Low Stock Medicines\n\n"
            );

            for (Medicine medicine :
                    lowStockMedicines) {

                message.append(
                        medicine.getName()
                );

                message.append(
                        " (Qty: "
                );

                message.append(
                        medicine.getQuantity()
                );

                message.append(
                        ")\n"
                );
            }

            JOptionPane.showMessageDialog(
                    this,
                    message.toString()
            );
        });

        expiryAlertButton.addActionListener(e -> {

            List<Medicine> expiringMedicines =
                    new ExpiryService()
                            .getExpiringMedicines();

            if (expiringMedicines.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No Medicines Expiring Soon"
                );

                return;
            }

            StringBuilder message =
                    new StringBuilder();

            message.append(
                    "Medicines Expiring Within 30 Days\n\n"
            );

            for (Medicine medicine :
                    expiringMedicines) {

                message.append(
                        medicine.getName()
                );

                message.append(
                        " - "
                );

                message.append(
                        medicine.getExpiryDate()
                );

                message.append(
                        "\n"
                );
            }

            JOptionPane.showMessageDialog(
                    this,
                    message.toString()
            );
        });

        exitButton.addActionListener(
                e -> System.exit(0)
        );
    }
}
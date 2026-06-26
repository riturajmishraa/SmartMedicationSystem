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

        setSize(700, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel =
                new JLabel(
                        "SMART MEDICATION SYSTEM",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        mainPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setLayout(
                new GridLayout(
                        7,
                        1,
                        15,
                        15
                )
        );

        addMedicineButton =
                new JButton(
                        "Add Medicine"
                );

        nextMedicineButton =
                new JButton(
                        "Next Medicine"
                );

        inventoryButton =
                new JButton(
                        "Inventory"
                );

        lowStockButton =
                new JButton(
                        "Low Stock Alert"
                );

        expiryAlertButton =
                new JButton(
                        "Expiry Alert"
                );

        historyButton =
                new JButton(
                        "History"
                );

        exitButton =
                new JButton(
                        "Exit"
                );

        buttonPanel.add(
                addMedicineButton
        );

        buttonPanel.add(
                nextMedicineButton
        );

        buttonPanel.add(
                inventoryButton
        );

        buttonPanel.add(
                lowStockButton
        );

        buttonPanel.add(
                expiryAlertButton
        );

        buttonPanel.add(
                historyButton
        );

        buttonPanel.add(
                exitButton
        );

        mainPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

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
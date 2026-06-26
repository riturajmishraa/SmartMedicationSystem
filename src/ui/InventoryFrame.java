package ui;

import datastructure.UndoStack;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Medicine;
import service.MedicineService;

public class InventoryFrame extends JFrame {

    private JTable medicineTable;

    private DefaultTableModel tableModel;

    private JTextField searchField;

    private JButton searchButton;

    private JButton deleteButton;

    private JButton undoButton;

    private JButton refreshButton;

    public InventoryFrame() {

        initializeUI();
    }

    private void initializeUI() {

        setTitle("Medicine Inventory");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();

        searchField = new JTextField(20);

        searchButton = new JButton("Search");

        deleteButton = new JButton("Delete");

        undoButton = new JButton("Undo Delete");

        refreshButton = new JButton("Refresh");

        topPanel.add(new JLabel("Medicine Name"));

        topPanel.add(searchField);

        topPanel.add(searchButton);

        topPanel.add(deleteButton);

        topPanel.add(undoButton);

        topPanel.add(refreshButton);

        add(topPanel, BorderLayout.NORTH);

        String[] columns = {
                "Name",
                "Dosage",
                "Time",
                "Quantity",
                "Expiry Date"
        };

        tableModel =
                new DefaultTableModel(columns, 0);

        medicineTable =
                new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(medicineTable);

        add(scrollPane, BorderLayout.CENTER);

        loadTableData();

        registerEvents();

        setVisible(true);
    }

    private void loadTableData() {

        tableModel.setRowCount(0);

        List<Medicine> medicines =
                MedicineService
                        .getInstance()
                        .getAllMedicines();

        for (Medicine medicine : medicines) {

            tableModel.addRow(new Object[]{

                    medicine.getName(),

                    medicine.getDosage(),

                    medicine.getTime(),

                    medicine.getQuantity(),

                    medicine.getExpiryDate()
            });
        }
    }

    private void registerEvents() {

        searchButton.addActionListener(e -> {

            String medicineName =
                    searchField.getText();

            Medicine medicine =
                    MedicineService
                            .getInstance()
                            .searchMedicine(
                                    medicineName
                            );

            if (medicine != null) {

                JOptionPane.showMessageDialog(
                        this,

                        "Medicine Found\n\n"
                                + "Name: "
                                + medicine.getName()
                                + "\nDosage: "
                                + medicine.getDosage()
                                + "\nQuantity: "
                                + medicine.getQuantity()
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Medicine Not Found"
                );
            }
        });

        deleteButton.addActionListener(e -> {

            int row =
                    medicineTable.getSelectedRow();

            if (row == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Select a medicine first"
                );

                return;
            }

            String medicineName =
        tableModel
                .getValueAt(row, 0)
                .toString();

        Medicine medicine =
                MedicineService
                .getInstance()
                .getMedicineByName(
                        medicineName
                );

                UndoStack
                .getInstance()
                .push(medicine);

        boolean deleted =
                MedicineService
                .getInstance()
                .deleteMedicine(
                        medicineName
                );

            if (deleted) {

                JOptionPane.showMessageDialog(
                        this,
                        "Medicine Deleted"
                );

                loadTableData();
            }
        });

        undoButton.addActionListener(e -> {

    Medicine medicine =
            UndoStack
                    .getInstance()
                    .pop();

    if (medicine == null) {

        JOptionPane.showMessageDialog(
                this,
                "Nothing to Undo"
        );

        return;
    }

    MedicineService
        .getInstance()
        .restoreMedicine(medicine);

    loadTableData();

    JOptionPane.showMessageDialog(
            this,
            "Medicine Restored"
    );
});

        refreshButton.addActionListener(e -> {

            loadTableData();
        });
    }
}
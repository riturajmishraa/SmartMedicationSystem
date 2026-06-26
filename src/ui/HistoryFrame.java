package ui;

import model.History;
import service.HistoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HistoryFrame extends JFrame {

    public HistoryFrame() {

        setTitle("Activity History");

        setSize(700,400);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        String[] columns = {
                "Action",
                "Medicine",
                "Date Time"
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );

        List<History> historyList =
                HistoryService
                        .getInstance()
                        .getAllHistory();

        for(History history : historyList) {

            model.addRow(
                    new Object[] {

                            history.getAction(),

                            history.getMedicineName(),

                            history.getTimestamp()
                    }
            );
        }

        JTable table =
                new JTable(model);

        add(
                new JScrollPane(table),
                BorderLayout.CENTER
        );

        setVisible(true);
    }
}
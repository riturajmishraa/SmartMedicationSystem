package service;

import model.History;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class HistoryService {

    private static HistoryService instance;

    private LinkedList<History> historyList;

    private HistoryService() {

        historyList = new LinkedList<>();
    }

    public static HistoryService getInstance() {

        if(instance == null) {

            instance = new HistoryService();
        }

        return instance;
    }

    public void addHistory(
            String action,
            String medicineName) {

        String time =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "dd-MM-yyyy HH:mm:ss"
                                )
                        );

        historyList.addFirst(
                new History(
                        action,
                        medicineName,
                        time
                )
        );
    }

    public List<History> getAllHistory() {

        return historyList;
    }
}
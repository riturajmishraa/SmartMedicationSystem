package datastructure;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import model.Medicine;

public class ReminderQueue {

    private PriorityQueue<Medicine> queue;

    private DateTimeFormatter formatter;

    public ReminderQueue() {

        formatter =
        DateTimeFormatter.ofPattern(
                "hh:mm a",
                java.util.Locale.ENGLISH
        );

        queue =
                new PriorityQueue<>(
                        (m1, m2) -> {

                            LocalTime t1 =
        LocalTime.parse(
                m1.getTime().trim(),
                formatter
        );

LocalTime t2 =
        LocalTime.parse(
                m2.getTime().trim(),
                formatter
        );

                            return t1.compareTo(t2);
                        }
                );
    }

    public void addMedicine(
            Medicine medicine) {

        queue.offer(medicine);
    }

    public Medicine getNextMedicine() {

        return queue.peek();
    }

    public boolean isEmpty() {

        return queue.isEmpty();
    }
}
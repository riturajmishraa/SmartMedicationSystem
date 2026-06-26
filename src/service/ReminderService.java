package service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import model.Medicine;

public class ReminderService {

    public Medicine getNextMedicine() {

        List<Medicine> medicines =
                MedicineService
                        .getInstance()
                        .getAllMedicines();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "hh:mm a",
                        Locale.ENGLISH
                );

        LocalTime currentTime =
                LocalTime.now();

        Medicine nextMedicine = null;

        LocalTime nextTime = null;

        for (Medicine medicine : medicines) {

            LocalTime medicineTime =
                    LocalTime.parse(
                            medicine.getTime().trim(),
                            formatter
                    );

            if (medicineTime.isAfter(currentTime)) {

                if (nextTime == null ||
                        medicineTime.isBefore(nextTime)) {

                    nextTime = medicineTime;

                    nextMedicine = medicine;
                }
            }
        }

        return nextMedicine;
    }
}
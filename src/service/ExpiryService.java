package service;

import model.Medicine;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExpiryService {

    public List<Medicine> getExpiringMedicines() {

        List<Medicine> expiring =
                new ArrayList<>();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy"
                );

        LocalDate today =
                LocalDate.now();

        List<Medicine> medicines =
                MedicineService
                        .getInstance()
                        .getAllMedicines();

        for (Medicine medicine : medicines) {

            try {

                LocalDate expiryDate =
                        LocalDate.parse(
                                medicine.getExpiryDate(),
                                formatter
                        );

                if (!expiryDate.isBefore(today)
                        &&
                        expiryDate.isBefore(
                                today.plusDays(30)
                        )) {

                    expiring.add(medicine);
                }

            } catch (Exception ignored) {
            }
        }

        return expiring;
    }
}
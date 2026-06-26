package service;

import model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class LowStockService {

    public List<Medicine> getLowStockMedicines() {

        List<Medicine> lowStock =
                new ArrayList<>();

        List<Medicine> medicines =
                MedicineService
                        .getInstance()
                        .getAllMedicines();

        for (Medicine medicine : medicines) {

            if (medicine.getQuantity() < 5) {

                lowStock.add(medicine);
            }
        }

        return lowStock;
    }
}
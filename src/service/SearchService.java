package service;

import model.Medicine;

import java.util.HashMap;
import java.util.List;

public class SearchService {

    private HashMap<String, Medicine> medicineMap;

    public SearchService(List<Medicine> medicines) {

        medicineMap = new HashMap<>();

        for (Medicine medicine : medicines) {

            medicineMap.put(
                    medicine.getName().toLowerCase(),
                    medicine
            );
        }
    }

    public Medicine searchMedicine(String name) {

        return medicineMap.get(
                name.toLowerCase()
        );
    }
}
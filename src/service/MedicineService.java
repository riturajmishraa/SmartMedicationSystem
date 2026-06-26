package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Medicine;
import storage.FileManager;

public class MedicineService {

    private static MedicineService instance;

    private List<Medicine> medicines;

    private Map<String, Medicine> medicineMap;

    private int nextId = 1;

    private MedicineService() {

        medicines = FileManager.loadMedicines();

        medicineMap = new HashMap<>();

        for (Medicine medicine : medicines) {

            medicineMap.put(
                    medicine.getName().toLowerCase(),
                    medicine
            );
        }
    }

    public static MedicineService getInstance() {

        if (instance == null) {

            instance = new MedicineService();
        }

        return instance;
    }

    public void addMedicine(
            String name,
            String dosage,
            String time,
            int quantity,
            String expiryDate) {

        Medicine medicine =
                new Medicine(
                        nextId++,
                        name,
                        dosage,
                        time,
                        quantity,
                        expiryDate
                );

        medicines.add(medicine);

        medicineMap.put(
                medicine.getName().toLowerCase(),
                medicine
        );

        FileManager.saveMedicine(medicine);

        HistoryService
                .getInstance()
                .addHistory(
                        "ADDED",
                        medicine.getName()
                );
    }

    public void addMedicine(Medicine medicine) {

        medicines.add(medicine);

        medicineMap.put(
                medicine.getName().toLowerCase(),
                medicine
        );

        FileManager.saveMedicine(medicine);

        HistoryService
                .getInstance()
                .addHistory(
                        "ADDED",
                        medicine.getName()
                );
    }

    public List<Medicine> getAllMedicines() {

        return medicines;
    }

    // HASHMAP SEARCH O(1)
    public Medicine searchMedicine(String name) {

        return medicineMap.get(
                name.toLowerCase()
        );
    }

    public boolean deleteMedicine(String name) {

        for (Medicine medicine : medicines) {

            if (medicine.getName()
                    .equalsIgnoreCase(name)) {

                medicines.remove(medicine);

                // Remove from HashMap too
                medicineMap.remove(
                        medicine.getName().toLowerCase()
                );

                FileManager.saveAllMedicines(
                        medicines
                );

                HistoryService
                        .getInstance()
                        .addHistory(
                                "DELETED",
                                medicine.getName()
                        );

                return true;
            }
        }

        return false;
    }

    public Medicine getMedicineByName(String name) {

        return medicineMap.get(
                name.toLowerCase()
        );
    }

    public void restoreMedicine(
            Medicine medicine) {

        medicines.add(medicine);

        // Restore in HashMap too
        medicineMap.put(
                medicine.getName().toLowerCase(),
                medicine
        );

        FileManager.saveAllMedicines(
                medicines
        );

        HistoryService
                .getInstance()
                .addHistory(
                        "RESTORED",
                        medicine.getName()
                );
    }
}
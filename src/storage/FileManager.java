package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;

public class FileManager {

    private static final String FILE_PATH =
            "data/medicines.txt";

    public static void saveMedicine(Medicine medicine) {

        try (
                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter(FILE_PATH, true)
                        )
        ) {

            writer.write(
                    medicine.getName() + "," +
                    medicine.getDosage() + "," +
                    medicine.getTime() + "," +
                    medicine.getQuantity() + "," +
                    medicine.getExpiryDate()
            );

            writer.newLine();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static List<Medicine> loadMedicines() {

        List<Medicine> medicines =
                new ArrayList<>();

        File file =
                new File(FILE_PATH);

        if (!file.exists()) {

            return medicines;
        }

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(FILE_PATH)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts =
                        line.split(",");

                Medicine medicine =
                        new Medicine(
                                0,
                                parts[0],
                                parts[1],
                                parts[2],
                                Integer.parseInt(parts[3]),
                                parts[4]
                        );

                medicines.add(medicine);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return medicines;
    }

    public static void saveAllMedicines(
        List<Medicine> medicines) {

    try (
            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_PATH)
                    )
    ) {

        for (Medicine medicine : medicines) {

            writer.write(
                    medicine.getName() + "," +
                    medicine.getDosage() + "," +
                    medicine.getTime() + "," +
                    medicine.getQuantity() + "," +
                    medicine.getExpiryDate()
            );

            writer.newLine();
        }

    } catch (IOException e) {

        e.printStackTrace();
    }
}
}
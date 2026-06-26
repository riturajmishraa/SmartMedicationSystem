package model;

public class Medicine {

    private int id;

    private String name;

    private String dosage;

    private String time;

    private int quantity;

    private String expiryDate;

    public Medicine(
            int id,
            String name,
            String dosage,
            String time,
            int quantity,
            String expiryDate) {

        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.time = time;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public String getTime() {
        return time;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
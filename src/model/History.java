package model;

public class History {

    private String action;
    private String medicineName;
    private String timestamp;

    public History(
            String action,
            String medicineName,
            String timestamp) {

        this.action = action;
        this.medicineName = medicineName;
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
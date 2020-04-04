package group1.stayella.Model;

import javafx.scene.control.Button;

public class Charge {
    private int id;
    private int reservationId;
    private String key;
    private String label;
    private double price;


    public Charge() {}
    public Charge(int id, int  reservationId, String key, String label, double price) {
        this.key = key;
        this.label = label;
        this.price = price;
    }

    public String getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }

    public double getPrice() {
        return this.price;
    }

    public int getId() {
        return this.id;
    }

    public int getReservationId() {
        return this.reservationId;
    }
}

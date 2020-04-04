package group1.stayella.Model;

import javafx.scene.control.Button;

public class Charge {
    private int id;
    private int reservationId;
    private String key;
    private String label;
    private double price;
    private int chargesTotal;


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

    public int markedCharges(Button[] board) {
        // Parking for one night
        // Pet
        // Gym access
        // Storing luggage per day
        // Food amenities (Can be complimentary if guest staying in higher floor)
        // Extra bed
        // Access to washing room
        this.chargesTotal = 0;
        if (board[0].getText().equals("✓")) {
            this.chargesTotal += 30;
        }
        if (board[1].getText().equals("✓")) {
            this.chargesTotal += 30;
        }
        if (board[2].getText().equals("✓")) {
            this.chargesTotal += 20;
        }
        if (board[3].getText().equals("✓")) {
            this.chargesTotal += 10;
        }
        if (board[4].getText().equals("✓")) {
            this.chargesTotal += 10;
        }
        if (board[5].getText().equals("✓")) {
            this.chargesTotal += 25;
        }
        if (board[6].getText().equals("✓")) {
            this.chargesTotal += 10;
        }
        return chargesTotal;
    }

    public int getChargesTotal() {
        return chargesTotal;
    }
}

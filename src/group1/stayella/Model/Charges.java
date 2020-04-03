package group1.stayella.Model;

import javafx.scene.control.Button;

public class Charges {
    private static int chargesTotal;
    private int id;
    private int reservationId;
    private String key;
    private String label;
    private Double price;

    public Charges() {}

    public Charges(int id, int reservationId, String key, String label, Double price){
        this.id = id;
        this.reservationId = reservationId;
        this.key = key;
        this.label = label;
        this.price = price;
    }

    public void markedCharges(Button[] board) {
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
    }

    public int getChargesTotal() {
        return chargesTotal;
    }
}

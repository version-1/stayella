package group1.stayella.Model;

import java.util.Date;

public class CreditCard {
    private int id;
    private int guestId;
    private int cardNumber;
    private String cardHolderName;
    private int cardSecurityNumber;
    private Date expired;

    public CreditCard(int id, int guestId, int cardNumber, String cardHolderName, String cardCompany,
            int cardSecurityNumber, Date expired) {
        this.id = id;
        this.guestId = guestId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardSecurityNumber = cardSecurityNumber;
        this.expired = expired;
    }

    // setter
    public void setCardHolderName(String cardName) {
        this.cardHolderName = cardName;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardSecurityNumber(int cardSecurityNumber) {
        this.cardSecurityNumber = cardSecurityNumber;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    // getter
    public int getId() {
        return id;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getcardHolderName() {
        return cardHolderName;
    }

    public int getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public Date getExpired() {
        return expired;
    }
}

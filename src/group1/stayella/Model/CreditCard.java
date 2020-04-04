package group1.stayella.Model;

import java.util.Date;

public class CreditCard {
    private int id;
    private int guestId;
    private String cardNumber;
    private String cardHolderName;
    private String cardSecurityNumber;
    private Date expired;

    public CreditCard(int id, int guestId, String cardNumber, String cardHolderName, String cardCompany,
            String cardSecurityNumber, Date expired) {
        this.id = id;
        this.guestId = guestId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardSecurityNumber = cardSecurityNumber;

    }

    // setter
    public void setCardHolderName(String cardName) {
        this.cardHolderName = cardName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardSecurityNumber(String cardSecurityNumber) {
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

    public String getCardNumber() {
        return cardNumber;
    }

    public String getcardHolderName() {
        return cardHolderName;
    }

    public String getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public Date getExpired() {
        return expired;
    }
}

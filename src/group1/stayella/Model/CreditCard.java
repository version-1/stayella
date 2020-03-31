package group1.stayella.Model;

import java.util.Date;

public class CreditCard {
    private int cardNumber;
    private String cardHolderName;
    private int cardSecurityNumber;
    private Date expired;


    public CreditCard(int cardNumber, String cardHolderName, int cardSecurityNumber, Date expired) {
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

    //getter
    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public Date getExpired() {
        return expired;
    }
}

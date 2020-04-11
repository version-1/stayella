package group1.stayella.Model;

import java.time.LocalDate;
import java.util.Date;

public class CreditCard {
    private int id;
    private int guestId;
    private String cardNumber;
    private String cardHolderName;
    private String cardSecurityNumber;
    private String expired;

    public CreditCard(int id, String cardNumber, String cardHolderName,
            String cardSecurityNumber, String expired) {
        this.id = id;
        this.guestId = guestId;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardSecurityNumber = cardSecurityNumber;
        this.expired = expired;

    }

    // setter
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardSecurityNumber(String cardSecurityNumber) {
        this.cardSecurityNumber = cardSecurityNumber;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public String getExpired() {
        return expired;
    }

    //method
    // check the digits
    private boolean checkSecurityNumber(String cardSecurityNumber) {
        int cardDigit = cardNumber.length();
        int securityDigit = cardNumber.length();
        if (cardDigit == 15 && securityDigit == 4) {  // American Ex
            return true;
        } else if (cardDigit == 14 || cardDigit == 16) {  // others
            if (securityDigit == 3) {
                return true;
            }
        }
        System.out.println("Valid Input");
        return false;
    }

    //check expired
    public boolean checkExpired(String expiration) {
        Date today = new Date();
        int month = today.getMonth();
        int year = today.getYear();
        if (Integer.parseInt(expiration.substring(2, 5)) > year ||
                (Integer.parseInt(expiration.substring(2, 5)) == year &&
                        Integer.parseInt(expiration.substring(0, 1)) > month)) {
            System.out.println("Expired Date");
            return false;
        } else {
            return true;
        }
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", guestId=" + guestId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardSecurityNumber='" + cardSecurityNumber + '\'' +
                ", expired=" + expired +
                '}';
    }
}

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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public Date getExpired() {
        return expired;
    }

    //method
    // check the digits
    private boolean checkDigits(String cardNumber){
        int digit = cardNumber.length();
        if(digit < 14 || digit > 16) {
            System.out.println("Valid Input");
            return false;
        } else {
            return true;
        }
    }

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
    private boolean checkExpired(Date expired){
        Date today = new Date();
        if(expired.after(today)) {
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
}

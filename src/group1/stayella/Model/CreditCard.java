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
    public void setCardNumber(int cardNumber) {
        if(checkDigits(cardNumber)) {
            this.cardNumber = cardNumber;
        }
    }

    public void setCardHolderName(String cardName) {
        this.cardHolderName = cardName;
    }

    public void setCardSecurityNumber(int cardSecurityNumber) {
        if(checkSecurityNumber(cardSecurityNumber)) {
            this.cardSecurityNumber = cardSecurityNumber;
        }
    }

    public void setExpired(Date expired) {
        if(checkExpired(expired)) {
            this.expired = expired;
        }
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

    //method
    // check the digits
    private boolean checkDigits(int cardNumber){
        int digit = Integer.toString(cardNumber).length();
        if(digit < 14 || digit > 16) {
            System.out.println("Valid Input");
            return false;
        } else {
            return true;
        }
    }

    // check the digits
    private boolean checkSecurityNumber(int cardSecurityNumber) {
        int cardDigit = Integer.toString(cardNumber).length();
        int securityDigit = Integer.toString(cardNumber).length();
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

//    //check whether the card holder is the guest or not.
//    private boolean checkTheHolder(String cardHolderName){
//        if(cardHolderName != ){
//
//        }
//    }
}

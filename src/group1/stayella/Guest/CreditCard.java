package group1.stayella.Guest;

public class CreditCard {
    private int cardNumber;
    private String cardHolderName;
    private int cardSecurityNumber;
    private date expired;


    public CreditCard(int cardNumber, String cardHolderName, String cardCompany, int cardSecurityNumber, boolean expired) {
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

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    //getter
    public int getCardNumber() {
        return cardNumber;
    }

    public String getcardHolderName() {
        return cardHolderName;
    }

    public int getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public boolean getExpired() {
        return expired;
    }
}

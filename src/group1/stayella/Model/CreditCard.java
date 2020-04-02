package group1.stayella.Model;

public class CreditCard {
    private int cardNumber;
    private String cardHolderName;
    private int cardSecurityNumber;



    public CreditCard(int cardNumber, String cardHolderName, String cardCompany, int cardSecurityNumber, boolean expired) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardSecurityNumber = cardSecurityNumber;

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

}

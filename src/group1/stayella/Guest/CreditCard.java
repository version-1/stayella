package group1.stayella.Guest;

public class CreditCard {
    private int cardNumber;
    private String cardName;
    private String cardCompany;
    private int cardSecurityNumber;


    public CreditCard(int cardNumber, String cardName, String cardCompany, int cardSecurityNumber) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardCompany = cardCompany;
        this.cardSecurityNumber = cardSecurityNumber;

    }


    // setter
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardSecurityNumber(int cardSecurityNumber) { this.cardSecurityNumber = cardSecurityNumber;
    }

    public void setCardCompany(String cardCompany) {
        this.cardCompany = cardCompany;
    }

    //getter

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardCompany() {
        return cardCompany;
    }

    public int getCardSecurityNumber() {
        return cardSecurityNumber;
    }

}

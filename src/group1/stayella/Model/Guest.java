package group1.stayella.Model;

import javafx.scene.image.ImageView;

import java.awt.*;

public class Guest {
    private int id;
    private String name;
    private String age;
    private     javafx.scene.image.Image photo;
    private String phoneNumber;
    private String emailAddress;
    private String idNumber;
    private CreditCard paymentMethod;
    private String language;

    public Guest() {
    }

    public Guest(int id, String name, String age, javafx.scene.image.Image image, String phoneNumber, String emailAddress, String idNumber, CreditCard paymentMethod, String language) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.photo = image; // what format of image do we want
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.idNumber = idNumber;
        this.paymentMethod = paymentMethod;
        this.language = language;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setImage(javafx.scene.image.Image photo) {
        this.photo = photo;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPaymentMethod(CreditCard paymentMethod) {
        if(paymentMethod.getCardHolderName() != null && nameCheck(paymentMethod.getCardHolderName())) {
            this.paymentMethod = paymentMethod;
        }
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getIdNumber() {
        return idNumber;
    }

    public String getLanguage() {
        return language;
    }


    public CreditCard getPaymentMethod() {
        return paymentMethod;
    }

    // name check
    private boolean nameCheck(String name){
        if( this.name.toUpperCase() == name.toUpperCase()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", photo=" + photo +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", language='" + language + '\'' +
                '}';
    }
}

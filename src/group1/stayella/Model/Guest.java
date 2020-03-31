package group1.stayella.Model;

public class Guest {
    private int id;
    private String name;
    private int age;
//         private String image;
    private String phoneNumber;
    private String email;
    private String idNumber;
    private CreditCard paymentMethod;
    private String language;
    public Guest() {

    }

    public Guest(int id, String name, int age, String phoneNumber, String email, String idNumber, CreditCard paymentMethod, String language) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
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


}

package group1.stayella.Hotel;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String url;
    private int deposit;
    private int parkingCapacity;
//    private Room[] rooms;

    public Hotel() {
    }


    public Hotel(int id, String name, String address, String phoneNumber, String email, String url, int deposit, int parkingCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.url = url;
        this.deposit = deposit;
        this.parkingCapacity = parkingCapacity;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    // getter


    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }
}

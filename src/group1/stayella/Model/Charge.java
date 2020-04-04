package group1.stayella.Model;

public class Charge {
    private int id;
    private int reservationId;
    private Facility facility;

    public Charge() {}
    public Charge(int id, int  reservationId, Facility facility) {
        this.id = id;
        this.reservationId = reservationId;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Facility getFacility() {
        return facility;
    }
}

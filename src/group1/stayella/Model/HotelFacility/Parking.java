package group1.stayella.Model.HotelFacility;

public class Parking extends HotelFacility {
  private String key = "parking";
  private String label = "Parking";

  public Parking(int id, double price, double capcity) {
    super(id, price, capcity);
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString() {
    return "Parking{" +
            "label='" + label +
            '}';
  }
}

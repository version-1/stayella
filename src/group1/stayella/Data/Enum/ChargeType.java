package group1.stayella.Data.Enum;

public  enum ChargeType {
  PARKING("Parking", 100),
  GYM("Gym", 100),
  Luggage("Storing Luggage", 100),
  FOOD_AMENITIES("Food Amenities", 100),
  EXTRA_BED("Extra bed", 100),
  REFRIGERATOR("Refrigerator", 100),
  BATH("Bath", 100),
  BALCONY("Balcony", 100),
  VIEW("View", 100),
  ACCESSIBLE_FOR_DISABILITIES("Accessible for disabilities", 0);

  private final String label;
  private final double price;

  private ChargeType(String label, double price) {
    this.label = label;
    this.price = price;
  }

  public String getLabel() {
    return this.label;
  }

  public double getPrice() {
    return this.price;
  }

}
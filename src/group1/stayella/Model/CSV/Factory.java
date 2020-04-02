package group1.stayella.Model.CSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import group1.stayella.Data.Enum.ChargeType;
import group1.stayella.Model.*;

public class Factory {
  private final static String CSV_DATA_PATH = "src/group1/stayella/Data/";
  private final static String CHARGE_PATH = CSV_DATA_PATH + "charge.csv";
  private final static String HOTEL_FACILITY_PATH = CSV_DATA_PATH + "hotel_facility.csv";
  private final static String HOTEL_PATH = CSV_DATA_PATH + "hotel.csv";
  private final static String RESERVATION_PATH = CSV_DATA_PATH + "resrcation.csv";
  private final static String CREDIT_CARD_PATH = CSV_DATA_PATH + "credit_card.csv";
  private final static String GUEST_PATH = CSV_DATA_PATH + "guest.csv";
  private final static String VACANCY_PATH = CSV_DATA_PATH + "vacancy.csv";

  public static List<Charge> getCharges() {
    try {
      List<HashMap<String, String>> csv = new Core(CHARGE_PATH).load();
      List<Charge> list = new ArrayList<Charge>();
      for (HashMap<String, String> row: csv) {
        ChargeType type = ChargeType.valueOf(row.get("KEY"));
        Charge charge = new Charge(
          type.name(),
          type.getLabel(),
          type.getPrice()
        );
        list.add(charge);
      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void getHotelFacilities() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(HOTEL_FACILITY_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getHotels() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(HOTEL_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getReservations() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(RESERVATION_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getCreditCards() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(CREDIT_CARD_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getGuests() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(GUEST_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getVacancies() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Core(VACANCY_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
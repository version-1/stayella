package group1.stayella.Model.CSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Factory {
  private final static String CSV_DATA_PATH = "./Data/";
  private final static String CHARGE_PATH = CSV_DATA_PATH + "charge.csv";
  private final static String HOTEL_FACILITY_PATH = CSV_DATA_PATH + "hotel_facility.csv";
  private final static String HOTEL_PATH = CSV_DATA_PATH + "hotel.csv";
  private final static String RESERVATION_PATH = CSV_DATA_PATH + "resrcation.csv";
  private final static String CREDIT_CARD_PATH = CSV_DATA_PATH + "credit_card.csv";
  private final static String GUEST_PATH = CSV_DATA_PATH + "guest.csv";
  private final static String VACANCY_PATH = CSV_DATA_PATH + "vacancy.csv";

  public static void getCharges() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(CHARGE_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getHotelFacilities() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(HOTEL_FACILITY_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getHotels() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(HOTEL_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getReservations() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(RESERVATION_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getCreditCards() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(CREDIT_CARD_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getGuests() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(GUEST_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void getVacancies() {
    // TODO: inmplement process to load from csv and create instance list
    try {
      List<HashMap<String, String>> csv = new Main(VACANCY_PATH).load();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
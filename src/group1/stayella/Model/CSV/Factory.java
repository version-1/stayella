package group1.stayella.Model.CSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import group1.stayella.Data.Enum.ChargeType;
import group1.stayella.Model.*;
import group1.stayella.Model.HotelFacility.*;

public class Factory {
  private final static String CSV_DATA_PATH = "src/group1/stayella/Data/";
  private final static String CHARGE_PATH = CSV_DATA_PATH + "charge.csv";
  private final static String HOTEL_FACILITY_PATH = CSV_DATA_PATH + "hotel_facility.csv";
  private final static String HOTEL_PATH = CSV_DATA_PATH + "hotel.csv";
  private final static String RESERVATION_PATH = CSV_DATA_PATH + "resrcation.csv";
  private final static String CREDIT_CARD_PATH = CSV_DATA_PATH + "credit_card.csv";
  private final static String GUEST_PATH = CSV_DATA_PATH + "guest.csv";
  private final static String VACANCY_PATH = CSV_DATA_PATH + "vacancy.csv";
  private final static String ROOM_PATH = CSV_DATA_PATH + "vacancy.csv";
  private final static String ROOM_FACILITY_PATH = CSV_DATA_PATH + "room_facility.csv";

  public static void initialize() {
    List<Hotel> hotels = getHotels();
    for (Hotel hotel: hotels) {
      hotel.setFacilities(getHotelFacilities(hotel.getID()));

    }
  }

  public static List<HotelFacility> getHotelFacilities(int id) {
    try {
      List<HashMap<String, String>> csv = new Core(HOTEL_FACILITY_PATH).load();
      List<HotelFacility> list = new ArrayList<HotelFacility>();
      for (HashMap<String, String> row: csv) {
        ChargeType type = ChargeType.valueOf(row.get("KEY"));
        if (toInt(row.get("ID")) == id) {
          HotelFacility hotelFacility = HotelFacility.getInstance(row.get("KEY"), row.get("PRICE"), row.get("PRICE"));
          list.add(hotelFacility);
        }
      }
      return list;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static List<Hotel> getHotels() {
    try {
      List<HashMap<String, String>> csv = new Core(HOTEL_PATH).load();
      List<Hotel> hotels = new ArrayList<Hotel>();
      for (HashMap<String, String> row: csv) {
        Hotel hotel = new Hotel(
          toInt(row.get("ID")),
          row.get("NAME"),
          row.get("ADDRESS"),
          row.get("PHONE_NUMBER"),
          row.get("EMAIL"),
          row.get("URL"),
          toInt(row.get("DEPOSIT")),
          toInt(row.get("PARKING_CAPACITY"))
        );
        hotels.add(hotel);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<Room> getRooms() {
    try {
      List<HashMap<String, String>> csv = new Core(ROOM_PATH).load();
      List<Room> list = new ArrayList<Room>();
      for(HashMap<String, String> row: csv){
        Room room = new Room(
          toInt(row.get("ID")),
          toInt(row.get("HOTEL_ID")),
          row.get("NO"),
          toInt(row.get("CAPACITY")),
          toInt(row.get("PRICE")),
          row.get("BED_TYPE"),
          toInt(row.get("NUMBER_OF_BEDS")),
          toInt(row.get("STATUS"))
        );
        list.add(room);
      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<RoomFacility> getRoomFacilities() {
    try {
      List<HashMap<String, String>> csv = new Core(ROOM_FACILITY_PATH).load();
      List<RoomFacility> list = new ArrayList<RoomFacility>();
      for(HashMap<String, String> row: csv){
        RoomFacility facility = new RoomFacility(
          toInt(row.get("ID")),
          toInt(row.get("ROOM_ID")),
          row.get("KEY"),
          row.get("LABEL")
        );
        list.add(facility);
      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  public static List<Charge> getCharges() {
    // try {
    //   List<HashMap<String, String>> csv = new Core(CHARGE_PATH).load();
    //   List<Charge> list = new ArrayList<Charge>();
    //   for (HashMap<String, String> row: csv) {
    //     ChargeType type = ChargeType.valueOf(row.get("KEY"));
    //     Charge charge = new Charge(
    //       toInt(row.get("ID")),
    //       toInt(row.get("RESRVATION_ID")),
    //       type.name(),
    //       type.getLabel(),
    //       type.getPrice()
    //     );
    //     list.add(charge);
    //   }
    //   return list;
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }
    return null;
  }

  public static void getReservations() {
    try {
      List<HashMap<String, String>> csv = new Core(RESERVATION_PATH).load();
      // List<Resorvation> reservations = new ArrayList<Resorvation>();
      // TODO: implement after Resrvation class is created
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<CreditCard> getCreditCards() {
    try {
      List<HashMap<String, String>> csv = new Core(CREDIT_CARD_PATH).load();
      List<CreditCard> list = new ArrayList<CreditCard>();
      for(HashMap<String, String> row: csv){
        CreditCard card = new CreditCard(
          toInt(row.get("ID")),
          toInt(row.get("GUEST_ID")),
          row.get("NUMBER"),
          row.get("NAME"),
          row.get("BRAND"),
          row.get("SECURITY_NUMBER"),
          toDate(row.get("EXPIRE"))
        );
        list.add(card);

      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<Guest> getGuests() {
    try {
      List<HashMap<String, String>> csv = new Core(GUEST_PATH).load();
      List<Guest> list = new ArrayList<Guest>();
      for(HashMap<String, String> row: csv){
        Guest guest = new Guest(
          toInt(row.get("ID")),
          toInt(row.get("RESERVAITON_ID")),
          row.get("NAME"),
          toInt(row.get("AGE")),
          row.get("PHONE_NUMBER"),
          row.get("EMAIL"),
          row.get("ID_NUMBER"),
          null,
          row.get("LANGUAGE")
        );
        list.add(guest);
      }
      return list;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
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

  private static int toInt(String str) {
    return Integer.parseInt(str);
  }

  private static Date toDate(String str) {
    return new Date(str);
  }
}
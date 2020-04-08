package group1.stayella.View.CalendarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;

public class Calendar {
    public final static int DATE_SPAN = 7;
    public final static int HOUR_SPAN = 6;
    private Date currentDate;
    private List<Date> dateList;
    private List<Date> hourList;
    private List<Room> rooms;

    public Calendar(List<Room> rooms) {
        this.rooms = rooms;
        currentDate = new Date();
        setDateList();
        setHourList();
    }

    public void setCurrentDate(Date date) {
        this.currentDate = date;
        setDateList();
        setHourList();
    }

    private void setDateList() {
        dateList = new ArrayList<Date>();
        for (int i = 0; i <= DATE_SPAN; i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(java.util.Calendar.DATE, i);

            dateList.add(cal.getTime());
        }
    }

    private void setHourList() {
        dateList = new ArrayList<Date>();
        for (int i = 0; i < HOUR_SPAN; i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(java.util.Calendar.DATE, i);

            dateList.add(cal.getTime());
        }
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public List<Date> getHourList() {
        return hourList;
    }

    public String getDateString() {
       return Vacancy.getDateString(currentDate, Vacancy.CALENDAR_DATE_FORMAT);
    }

    public String getDateString(Date date) {
       return Vacancy.getDateString(date, Vacancy.CALENDAR_DATE_FORMAT);
    }
}

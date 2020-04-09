package group1.stayella.View.CalendarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import group1.stayella.Model.Room;
import group1.stayella.Model.Vacancy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Calendar {
    public final static int DATE_SPAN = 7;
    public final static int HOUR_SPAN = 6;
    private Date currentDate;
    private List<Date> dateList;
    private List<Date> hourList;

    public Calendar() {
        currentDate = new Date();
        setDateList();
    }

    public void setCurrentDate(Date date) {
        this.currentDate = date;
        setDateList();
    }

    private void setDateList() {
        dateList = new ArrayList<Date>();
        for (int i = 0; i < DATE_SPAN; i++) {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(java.util.Calendar.DATE, i);

            dateList.add(cal.getTime());
        }
    }

    public static Date getStartOfDay(Date date) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        int day = calendar.get(java.util.Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date add(Date date, int type, int delta) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, delta);
        return calendar.getTime();
    }

    public void buildVacanciesTable(TableView table) {
        int count = 24 / HOUR_SPAN;
        for (Date date : getDateList()) {
            TableColumn<Room, HashMap<String, Vacancy>> col = new TableColumn<>(getDateString(date));
            Date startOfDay = getStartOfDay(date);
            for (int i = 0; i < count; i++) {
                Date time = Calendar.add(startOfDay, java.util.Calendar.HOUR, i * HOUR_SPAN);
                String timeStr = getTimeString(time);
                TableColumn<Room, HashMap<String, Vacancy>> term = new TableColumn<>(timeStr);
                term.setCellValueFactory(new PropertyValueFactory<>("vacancyMap"));
                // Custom rendering of the table cell.
                term.setCellFactory(column -> {
                    return new TableCell() {
                        @Override
                        protected void updateItem(Object item , boolean empty) {
                            String key = getDateTimeString(time);
                            HashMap<String, Vacancy> map  = (HashMap<String, Vacancy>) item;
                            if (map != null) {
                              Vacancy v = map.get(key);
                                if (v != null && v.isOccupied()) {
                                    getStyleClass().add(v.getFilledClass());
                                }
                            }

                            super.updateItem(item, empty);

                        }
                    };
                });
                col.getColumns().add(term);
            }
            table.getColumns().add(col);
        }
    }

    public void tomorrow() {
        Date tomorrow = add(currentDate, java.util.Calendar.DATE, 1);
        setCurrentDate(tomorrow);
    }

    public void yesterday() {
        Date yesterday = add(currentDate, java.util.Calendar.DATE, -1);
        setCurrentDate(yesterday);
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

    public String getTimeString(Date date) {
        return Vacancy.getDateString(date, Vacancy.CALENDAR_TIME_FORMAT);
    }

    public String getDateTimeString(Date date) {
        return Vacancy.getDateString(date, Vacancy.CALENDAR_DATETIME_FORMAT);
    }
}

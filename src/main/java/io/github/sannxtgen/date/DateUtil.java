package io.github.sannxtgen.date;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

    //Class Constants
    private final static String DATE_FORMAT = "MM/dd/yyyy";

    /**
     * Get local date in MM/dd/yyyy pattern
     *
     * @return Current date will be returned as String
     */
    public static String getDate() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
        LocalDate date = new LocalDate();
        return formatter.print(date);
    }

    /**
     * Get local date in given date format
     *
     * @param dateFormat Provide the date format e.g. MM/dd/yyyy
     * @return Current date will be returned as String in the requested format
     */
    public static String getDate(String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(dateFormat);
        LocalDateTime date = new LocalDateTime();
        return formatter.print(date);
    }

    /**
     * Get local time in given time format
     *
     * @param timeFormat Provide the time format e.g. HH-mm
     * @return Current time will be returned as String int he requested format
     */
    public static String getTime(String timeFormat) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(timeFormat);
        LocalTime time = new LocalTime();
        return formatter.print(time);
    }
}
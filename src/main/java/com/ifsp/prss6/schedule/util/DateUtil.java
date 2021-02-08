package com.ifsp.prss6.schedule.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author vinicius.montouro
 */
public class DateUtil {

    /**
     * pattern date br
     */
    private static final String PATTERN_DATE_BR = "dd-MM-yyyy";

    /**
     * convert string in LocalDate
     * @param date
     * @return LocalDate
     */
    public static LocalDate parseDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(PATTERN_DATE_BR));
    }

    /**
     * Convert LocalDate in String
     * @param date
     * @return String
     */
    public static String parseDate(LocalDate date){
        if(date == null)
            return StringsUtil.EMPTY;
        return new SimpleDateFormat(PATTERN_DATE_BR).format(date);
    }
}

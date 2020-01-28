package com.travix.medusa.busyflights.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String ISO_LOCAL_DATE = "yyyy-MM-dd";

    public static String fromLocalDateTimeToDateTime(String in) {
        LocalDateTime localDateTime = LocalDateTime.parse(in, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public static String fromInstantToDateTime(String in) {
        Instant instant = Instant.from(DateTimeFormatter.ISO_INSTANT.parse(in));
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}

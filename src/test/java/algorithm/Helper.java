package algorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Helper {
    public static String userTimeStampParam(boolean isYear, boolean isMonth, boolean isDay, boolean isHour, boolean isMinute, boolean isSecond) {
        LocalDateTime localTime = LocalDateTime.now(ZoneId.of("GMT+2"));
        String result = "";
        if (isYear) result = result + String.format("%02d", localTime.getYear()).substring(2, 4);
        if (isMonth) result = result + String.format("%02d", localTime.getMonthValue());
        if (isDay) result = result + String.format("%02d", localTime.getDayOfMonth());
        if (isHour) result = result + String.format("%02d", localTime.getHour());
        if (isMinute) result = result + String.format("%02d", localTime.getMinute());
        if (isSecond) result = result + String.format("%02d", localTime.getSecond());
        return result;
    }
}

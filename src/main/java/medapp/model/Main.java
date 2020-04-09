package medapp.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalTime plusHour = localTime.plusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeNow = formatter.format(localTime);
        String timePlusHour = formatter.format(plusHour);
        System.out.println(timeNow);
        System.out.println(timePlusHour);
    }
}

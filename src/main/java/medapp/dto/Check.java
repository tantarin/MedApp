package medapp.dto;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
    public static void main(String[] args) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(LocalDate.now().toString());
    }
}

package medapp.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {
    public static void main(String[] args) {
        String[] weeks = {"Thuesday", "Friday", "Sunday"};
        List<Integer> weeksInt = new ArrayList<>();
        for(String s: weeks) {
            if(s.equals("Monday")) weeksInt.add(1);
            if(s.equals("Thuesday")) weeksInt.add(2);
            if(s.equals("Wednesday")) weeksInt.add(3);
            if(s.equals("Thursday")) weeksInt.add(4);
            if(s.equals("Friday")) weeksInt.add(5);
            if(s.equals("Saturday")) weeksInt.add(6);
            if(s.equals("Sunday")) weeksInt.add(7);
        }
        DayOfWeek date = LocalDate.now().getDayOfWeek();
        System.out.println(date);
        System.out.println(date.getValue());
 //       if(Arrays.asList(weeks).contains(date.getDayOfWeek().getValue()))
//        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
//        {
//            if(Arrays.asList(weeks).contains(date.getDayOfWeek().getValue())){

        //    }
    }
}

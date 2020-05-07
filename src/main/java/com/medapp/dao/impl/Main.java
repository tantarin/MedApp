package com.medapp.dao.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(now);
        String date2 = "2020-04-07";
        LocalDate test1 = LocalDate.parse(date, formatter);
        LocalDate test2 = LocalDate.parse(date2,formatter);
        System.out.println(test1.compareTo(test2));
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formattertime = DateTimeFormatter.ofPattern("HH:mm");
        String timeNow = formattertime.format(localTime);
        System.out.println(timeNow);
        LocalTime nowTime = LocalTime.parse(timeNow, formattertime);
        LocalTime timeEvent = LocalTime.parse("12:00",formattertime);
        System.out.println(nowTime.compareTo(timeEvent));


    }
}

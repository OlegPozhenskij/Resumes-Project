package com.java.main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainDate {
    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
        Date date = new Date();   // устарел!, выводит текущую тайм зону, их в date менять нельзя
//        System.out.println(date);
//        long finish = System.currentTimeMillis() - start;
//        System.out.println(finish);
//
//        System.out.println("-----------------");
//
//        Calendar calendar = Calendar.getInstance(); // уже лучше для работы с датой и временем
//        calendar.setTimeZone(TimeZone.getDefault());
//        System.out.println(calendar.getWeekYear());

        System.out.println("-----------------");

        LocalDate localDate = LocalDate.now(); // актуально и нужно пользоваться этим
        LocalTime localTime = LocalTime.now(); // Java 8 Date API
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println("-----------------");

        SimpleDateFormat sdf = new SimpleDateFormat("YY/MM"); // не поддерживает многопоточность
        System.out.println(sdf.format(date));

        System.out.println("-----------------");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY/MM");
        System.out.println(dtf.format(localDate));
    }
}

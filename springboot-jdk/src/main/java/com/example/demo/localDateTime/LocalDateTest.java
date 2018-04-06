package com.example.demo.localDateTime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by chenhe on 2018/4/3.
 */
public class LocalDateTest {
    @Test
    public void testToday(){
        LocalDate localDate = LocalDate.now();
        System.out.println("当前时间是:"+localDate);
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        System.out.println(String.format("%s年%s月%s日",year,month,day));
    }

    /**
     * 生日比较
     */
    @Test
    public void testDay(){
        MonthDay dateOfBirth = MonthDay.from(LocalDate.now());
        System.out.println("Your Date of birth is : " + dateOfBirth);
        Clock clock = Clock.systemUTC();
        System.out.println("获取时间戳的两种方式"+clock.millis()+"|"+System.currentTimeMillis());
    }

    @Test
    public void testParseDate(){
        String goodFriday = "08 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

    }
}

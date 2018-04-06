package com.example.demo.integer;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenhe on 2018/3/3.
 */
public class TestInteger {


    @Test
    public void testIntegerToString(){
        System.out.println("进制转换");
        String val = Integer.toString(10,2);
        System.out.println(val);
    }

    @Test
    public void testIntegerCache(){
        Integer integer = 10;
        Integer integer2 = 30;
        Integer integer1 = 10;
        Integer integer3 = 128;
        Integer integer4 = 128;

        System.out.println(integer == integer1);

        System.out.println(integer3 == integer4);

    }

    @Test
    public void testHashMap(){
        HashMap hashMap = new HashMap(1);
        hashMap.put("hello","workd");
    }

    @Test
    public void testPattern(){
        Pattern pattern = Pattern.compile("\\s+");
        BigDecimal bigDecimal = new BigDecimal("-10");
        System.out.println(pattern.matcher(" ").matches());
    }
    @Test
    public void testPattern2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for(int i = 1;i<= 5;i++){
            for(int j=10;j<= 50;){
                int range = i * 6 + j / 10 + 1;
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.add(Calendar.DAY_OF_YEAR, -range);
                Date endTime = calendar.getTime();
                calendar.add(Calendar.DAY_OF_YEAR, -1);
                Date startTime = calendar.getTime();
                System.out.println(range+" - "+simpleDateFormat.format(startTime)+"  -  "+simpleDateFormat.format(endTime));
                j = j+10;
                System.out.println("-------------------------");
            }
        }


    }
}

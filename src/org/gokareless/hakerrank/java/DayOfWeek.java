package org.gokareless.hakerrank.java;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DayOfWeek {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);
        int year = Integer.parseInt(input[2]);

        System.out.println(findDay(month, day, year));
    }

    public static String findDay(int month, int day, int year) {
        try {
            String strDate = String.format("%02d %02d %4d", month, day, year);

            SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
            Date date = sdf.parse(strDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            DateFormatSymbols dfs = new DateFormatSymbols();
            return dfs.getWeekdays()[weekday].toUpperCase();
        } catch (Exception ex) {
            return null;
        }
    }
}

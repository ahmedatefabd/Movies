package com.c1ctech.androiddagger2example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatDate {

    // Method is used for change the date format ("yyyy-MM-dd") to ("dd-MM-yyyy")
    public static  String formatDate(String date) {

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateBefore = null;

        try {
            dateBefore = dt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");


        String dateFinal = dateFormat1.format(dateBefore);

        return dateFinal;
    }
}

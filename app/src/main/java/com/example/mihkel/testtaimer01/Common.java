package com.example.mihkel.testtaimer01;

import android.util.Log;

import org.apache.commons.lang.StringUtils;

/**
 * Created by mihkel on 20.12.2015.
 */
public class Common {
    static void print(String input) {
        Log.v("xxxxxxxxxxxxxxx", input);
        Log.v("xxxxxxxxxxxxxxx", input);
        Log.v("xxxxxxxxxxxxxxx", input);
    }

    static String long2TimeString(long inputTime) {
        long timeElapsed = inputTime; //For example
        int hours = (int) (timeElapsed / 3600000);
        int minutes = (int) (timeElapsed - hours * 3600000) / 60000;
        int seconds = (int) (timeElapsed - hours * 3600000 - minutes * 60000) / 1000;
        return StringUtils.join(new Integer[]{hours,minutes,seconds},":");
    }
}

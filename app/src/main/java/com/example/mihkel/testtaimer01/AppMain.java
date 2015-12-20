package com.example.mihkel.testtaimer01;

import android.content.Context;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.Toast;

/**
 * Created by mihkel on 20.12.2015.
 */
public class AppMain {

    private Context context;
    private Chronometer chronometer;

    public AppMain(Context context) {
        this.context = context;
    }

    public String getStopwatchTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        return Common.long2TimeString(elapsedMillis);
    }

    public void startStopwatch() {
        chronometer = new Chronometer(this.context);
        chronometer.start();

    }
}

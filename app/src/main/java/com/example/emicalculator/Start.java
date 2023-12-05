package com.example.emicalculator;

import android.app.Application;
import android.widget.Toast;

public class Start extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "EMI Calculator", Toast.LENGTH_SHORT).show();
    }
}

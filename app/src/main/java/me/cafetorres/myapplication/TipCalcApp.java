package me.cafetorres.myapplication;

import android.app.Application;

/**
 * Created by Carlos on 12/10/2016.
 */

public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "http://www.google.com";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
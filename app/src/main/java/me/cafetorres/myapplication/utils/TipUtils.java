package me.cafetorres.myapplication.utils;

import java.text.SimpleDateFormat;

import me.cafetorres.myapplication.entity.TipRecord;

/**
 * Created by Carlos on 03/11/2016.
 */

public class TipUtils {
    public static double getTip(TipRecord tipRecord){
        return tipRecord.getBill()*(tipRecord.getTipPercentage()/100d);
    }
    public static String getTipFormated(TipRecord tipRecord){
        double b = tipRecord.getBill()*(tipRecord.getTipPercentage()/100d);
        return String.valueOf(b);
    }
   public String getBillFormated(TipRecord tipRecord){

        return String.valueOf(tipRecord.getBill());
    }
    public String getDateFormated(TipRecord tipRecord){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("MM dd, yyyy HH:mm");
        return simpleDateFormat.format(tipRecord.getTimestamp());
    }
}

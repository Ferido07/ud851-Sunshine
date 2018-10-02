package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;
import java.net.URL;

//  COMPLETED (1) Create a class called SunshineSyncTask
public class SunshineSyncTask {
//  COMPLETED (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    synchronized public static void syncWeather(Context context) {
//      COMPLETED (3) Within syncWeather, fetch new weather data
        URL networkRequestUrl = NetworkUtils.getUrl(context);
        try {
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(networkRequestUrl);
            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, jsonWeatherResponse);
            //      COMPLETED (4) If we have valid results, delete the old data and insert the new
            if (weatherValues != null && weatherValues.length != 0){
                ContentResolver resolver = context.getContentResolver();
                resolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,null,null);
                resolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI,weatherValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
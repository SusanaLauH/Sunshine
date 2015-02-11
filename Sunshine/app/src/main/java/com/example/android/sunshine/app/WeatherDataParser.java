package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SusanaLauH on 2/10/2015.
 */
public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {

        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray list = jsonObject.getJSONArray("list");
        JSONObject day = list.getJSONObject(dayIndex);
        JSONObject element = day.getJSONObject("temp");
        Double maxTemp = element.getDouble("max");
        return maxTemp;

    }

}


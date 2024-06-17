package com.braldo.bookingapp.util;

import com.braldo.bookingapp.model.Booking;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDateTime;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder()
            // register custom JsonSerializer for LocalDate
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static String toJson(Object obj) {
        return gson.toJson(obj) ;
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws IOException {
        return gson.fromJson(json, classOfT);
    }
}
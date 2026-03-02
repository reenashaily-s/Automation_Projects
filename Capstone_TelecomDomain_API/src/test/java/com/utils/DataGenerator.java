package com.utils;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataGenerator {
    public static String getUniqueEmail() {
        String timestamp = LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss"));
        return "user_" + timestamp + "@example.com";
    }
}
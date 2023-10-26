package com.anmi.doctorbooking.utills;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtility {
    private static long startTime;

    public static void start() {
        startTime = System.currentTimeMillis();
        log("Start");
    }

    public static void stop() {
        long endTime = System.currentTimeMillis();
        log("Stop ");
        long elapsedTime = endTime - startTime;
        double seconds = elapsedTime / 1000.0;
        log("Time taken: " + seconds + " seconds");
    }

    private static void log(String message) {
        log.info(message + " - " + getCurrentTime());
    }

    private static String getCurrentTime() {
        long currentTime = System.currentTimeMillis();
        return String.format("%tT:%<tL", currentTime);
    }


}

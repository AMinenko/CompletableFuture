package com.anmi.doctorbooking.utills;

import lombok.NoArgsConstructor;


@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public  class ServiceUtils {

    // Utility function to simulate delays
   public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

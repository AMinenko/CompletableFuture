package com.anmi.doctorbooking.microservices;

import static com.anmi.doctorbooking.utills.ServiceUtils.sleep;

public class DoctorAvailabilityService {

    public static boolean isDoctorAvailable() {
        // Simulate 2-second delay
        sleep(2000);
        return true;
    }
}

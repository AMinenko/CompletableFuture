package com.anmi.doctorbooking.microservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.anmi.doctorbooking.utills.ServiceUtils.sleep;

public class PatientInformationService {

    public static PatientInformation getPatientInformation() {
        // Simulate 1-second delay
        sleep(1000);
        return new PatientInformation("John Doe", "123 Main St");
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PatientInformation {
        private String name;
        private String address;
    }
}

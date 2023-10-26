package com.anmi.doctorbooking.microservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.anmi.doctorbooking.utills.ServiceUtils.sleep;

public class InsuranceService {
    public static InsuranceInformation getInsuranceInformation() {
        // Simulate 1-second delay
        sleep(1000);
        return new InsuranceInformation("XYZ Insurance", "Policy#12345");
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class InsuranceInformation {
        private String provider;
        private String policyNumber;
    }
}

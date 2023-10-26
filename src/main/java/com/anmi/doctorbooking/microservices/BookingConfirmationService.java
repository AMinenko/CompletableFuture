package com.anmi.doctorbooking.microservices;

import com.anmi.doctorbooking.microservices.InsuranceService.InsuranceInformation;
import com.anmi.doctorbooking.microservices.PatientInformationService.PatientInformation;

public class BookingConfirmationService {

    static void confirmBooking(PatientInformation patientInfo, InsuranceInformation insuranceInfo) {
        // Perform booking confirmation
        System.out.println("Booking confirmed for " + patientInfo.getName() + " with insurance " + insuranceInfo.getPolicyNumber());
    }
}

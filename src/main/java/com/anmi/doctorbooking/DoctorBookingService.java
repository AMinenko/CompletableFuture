package com.anmi.doctorbooking;

import com.anmi.doctorbooking.microservices.DoctorAvailabilityService;
import com.anmi.doctorbooking.microservices.InsuranceService;
import com.anmi.doctorbooking.microservices.PatientInformationService;
import com.anmi.doctorbooking.utills.TimeUtility;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class DoctorBookingService {

    public static void main(String[] args) {
        log.info("Running Booking Synchronously");
        bookAppointmentSync();

        log.info("Running Booking Asynchronously");
        bookAppointmentAsync();
    }

    public static void bookAppointmentSync() {
        TimeUtility.start();

        PatientInformationService.getPatientInformation();
        InsuranceService.getInsuranceInformation();
        DoctorAvailabilityService.isDoctorAvailable();

        TimeUtility.stop();
    }

    /**
     * Initiates asynchronous service calls to fetch patient information,
     * insurance details, and check doctor availability.
     *
     * - Three CompletableFutures are created for each service call, enabling parallel execution.
     * - CompletableFuture.supplyAsync() is used to asynchronously fetch the respective information.
     * - The results are combined using CompletableFuture.allOf() to await their completion.
     * - The main thread is blocked until all the service calls have finished.
     */
    public static void bookAppointmentAsync() {
        TimeUtility.start();
        // Creating CompletableFutures for each service call
        CompletableFuture<PatientInformationService.PatientInformation> patientInfoFuture = CompletableFuture.supplyAsync(
                PatientInformationService::getPatientInformation
        );

        CompletableFuture<InsuranceService.InsuranceInformation> insuranceInfoFuture = CompletableFuture.supplyAsync(
                InsuranceService::getInsuranceInformation
        );

        CompletableFuture<Boolean> doctorAvailabilityFuture = CompletableFuture.supplyAsync(
                DoctorAvailabilityService::isDoctorAvailable
        );

        // Combining independent tasks together and awaiting them to be finished
        CompletableFuture.allOf(patientInfoFuture, insuranceInfoFuture,
                        doctorAvailabilityFuture)
                .join();
        TimeUtility.stop();
    }
}

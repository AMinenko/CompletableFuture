package com.anmi.doctorbooking.microservices;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AppointmentService {

    /**
     * Method to simulate a service call to retrieve the list of available appointments for the given doctor.
     *
     * @param doctorId
     * @return List of available appointments for the given doctor.
     */
    public static List<Appointment> getAvailableAppointments(int doctorId) {
        log.info("Received call to get available appointments for doctor");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Appointments available. Returning information back to the caller.");
        return buildThreeAppointments(doctorId);
    }

    /**
     * Method returns a list of mocked appointments for the given doctor.
     */
    private static List<Appointment> buildThreeAppointments(int doctorId) {
        return List.of(
                Appointment.builder().doctorId(doctorId).appointmentTime("10:00 AM").build(),
                Appointment.builder().doctorId(doctorId).appointmentTime("11:00 AM").build(),
                Appointment.builder().doctorId(doctorId).appointmentTime("12:00 PM").build()
        );
    }

    @Getter
    @Builder
    public static class Appointment {
        int doctorId;
        String appointmentTime;
    }
}



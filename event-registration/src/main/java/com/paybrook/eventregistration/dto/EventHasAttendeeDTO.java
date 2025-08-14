package com.paybrook.eventregistration.dto;

import lombok.Data;

@Data
public class EventHasAttendeeDTO {
    private EventDetailsDTO eventDetailsDTO;
    private AttendeeDTO attendeeDTO;
}

package com.paybrook.eventregistration.dto.in;

import lombok.Data;

@Data
public class EventHasAttendeeInDTO {
    private int eventId;
    private int attendeeId;
}

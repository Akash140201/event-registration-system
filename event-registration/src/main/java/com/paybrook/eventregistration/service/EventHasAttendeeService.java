package com.paybrook.eventregistration.service;

import com.paybrook.eventregistration.dto.EventHasAttendeeDTO;
import com.paybrook.eventregistration.dto.in.EventHasAttendeeInDTO;

import java.util.List;

public interface EventHasAttendeeService {
    EventHasAttendeeDTO save(EventHasAttendeeInDTO eventHasAttendeeInDTO);

    List<EventHasAttendeeDTO> findAll();
}

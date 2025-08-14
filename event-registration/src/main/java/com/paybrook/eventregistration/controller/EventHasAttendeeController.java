package com.paybrook.eventregistration.controller;


import com.paybrook.eventregistration.constant.GlobalConstants;
import com.paybrook.eventregistration.dto.EventDetailsDTO;
import com.paybrook.eventregistration.dto.EventHasAttendeeDTO;
import com.paybrook.eventregistration.dto.in.EventDetailsInDTO;
import com.paybrook.eventregistration.dto.in.EventHasAttendeeInDTO;
import com.paybrook.eventregistration.requestparams.EventDetailsRequestParams;
import com.paybrook.eventregistration.service.EventHasAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = GlobalConstants.API + "/eventHasAttendee")
public class EventHasAttendeeController {
    @Autowired
    private EventHasAttendeeService eventHasAttendeeService;

    @PostMapping
    public EventHasAttendeeDTO save(@RequestBody @Validated EventHasAttendeeInDTO eventHasAttendeeInDTO)
    {
        return eventHasAttendeeService.save(eventHasAttendeeInDTO);
    }

    @GetMapping
    public List<EventHasAttendeeDTO> findAll()
    {
        return eventHasAttendeeService.findAll();
    }
}

package com.paybrook.eventregistration.controller;


import com.paybrook.eventregistration.constant.GlobalConstants;
import com.paybrook.eventregistration.dto.AttendeeDTO;
import com.paybrook.eventregistration.dto.in.AttendeeInDTO;
import com.paybrook.eventregistration.requestparams.AttendeeRequestParams;
import com.paybrook.eventregistration.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = GlobalConstants.API + "/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @PostMapping
    public AttendeeDTO save(@RequestBody @Validated AttendeeInDTO attendeeInDTO)
    {
        return attendeeService.save(attendeeInDTO);
    }

    @GetMapping("/{id}")
    public AttendeeDTO findOne(@PathVariable Integer id)
    {
        return attendeeService.findById(id);
    }

    @GetMapping
    public List<AttendeeDTO> findAll(AttendeeRequestParams attendeeRequestParams, Pageable pageable)
    {
        return attendeeService.findAll(attendeeRequestParams, pageable);
    }

    @PutMapping("/{id}")
    public AttendeeDTO update(
            @PathVariable Integer id,
            @Validated @RequestBody AttendeeInDTO attendeeInDTO)
    {
        return attendeeService.update(id, attendeeInDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id)
    {
        return attendeeService.delete(id);
    }

}

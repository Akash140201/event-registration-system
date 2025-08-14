package com.paybrook.eventregistration.controller;

import java.util.List;


import com.paybrook.eventregistration.constant.GlobalConstants;
import com.paybrook.eventregistration.dto.EventDetailsDTO;
import com.paybrook.eventregistration.dto.EventStatisticsDTO;
import com.paybrook.eventregistration.dto.in.EventDetailsInDTO;
import com.paybrook.eventregistration.requestparams.EventDetailsRequestParams;
import com.paybrook.eventregistration.service.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = GlobalConstants.API + "/eventDetails")
public class EventDetailsController
{
    @Autowired
    private EventDetailsService eventDetailsService;


    @PostMapping
    public EventDetailsDTO save(@RequestBody @Validated EventDetailsInDTO eventDetailsInDTO)
    {
        return eventDetailsService.save(eventDetailsInDTO);
    }

    @GetMapping("/{id}")
    public EventDetailsDTO findOne(@PathVariable Integer id)
    {
        return eventDetailsService.findById(id);
    }

    @GetMapping("/{id}/eventStatistics")
    public EventStatisticsDTO findStatistics(@PathVariable Integer id)
    {
        return eventDetailsService.getEventStatistics(id);
    }

    @GetMapping
    public List<EventDetailsDTO> findAll(EventDetailsRequestParams eventDetailsRequestParams, Pageable pageable)
    {
        return eventDetailsService.findAll(eventDetailsRequestParams, pageable);
    }

    @PutMapping("/{id}")
    public EventDetailsDTO update(
            @PathVariable Integer id,
            @Validated @RequestBody EventDetailsInDTO eventDetailsInDTO)
    {
        return eventDetailsService.update(id, eventDetailsInDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id)
    {
        return eventDetailsService.delete(id);
    }

    @PatchMapping("/{id}/cancel")
    public String cancelEvent(@PathVariable Integer id)
    {
        return eventDetailsService.cancelEvent(id);
    }
}
package com.paybrook.eventregistration.service;



import com.paybrook.eventregistration.dto.EventDetailsDTO;
import com.paybrook.eventregistration.dto.EventStatisticsDTO;
import com.paybrook.eventregistration.dto.in.EventDetailsInDTO;
import com.paybrook.eventregistration.entity.EventDetailsEntity;
import com.paybrook.eventregistration.requestparams.EventDetailsRequestParams;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EventDetailsService
{
    EventDetailsDTO save(EventDetailsInDTO eventDetailsInDTO);

    EventDetailsDTO findById(Integer id);

    List<EventDetailsDTO> findAll(EventDetailsRequestParams eventDetailsRequestParams, Pageable pageable);

    EventDetailsDTO update(Integer id, EventDetailsInDTO eventDetailsInDTO);

    String delete(Integer id);

    String cancelEvent(Integer id);

    EventDetailsEntity getEventDetailsEntity(Integer id);

    void incrementBookedSeatOfEvent(EventDetailsEntity eventDetailsEntity);

    EventStatisticsDTO getEventStatistics(Integer id);
}
package com.paybrook.eventregistration.mapper;

import com.paybrook.eventregistration.dto.EventHasAttendeeDTO;
import com.paybrook.eventregistration.entity.EventHasAttendeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AttendeeMapper.class, EventDetailsMapper.class})
public interface EventHasAttendeeMapper {

    @Mapping(target = "eventDetailsDTO", source = "eventDetailsEntity")
    @Mapping(target = "attendeeDTO", source = "attendeeEntity")
    EventHasAttendeeDTO toDTO(EventHasAttendeeEntity eventHasAttendeeEntity);

    List<EventHasAttendeeDTO> toDTOs(List<EventHasAttendeeEntity> eventHasAttendeeEntities);
}

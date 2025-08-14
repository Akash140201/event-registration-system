package com.paybrook.eventregistration.mapper;

import java.util.List;


import com.paybrook.eventregistration.dto.EventDetailsDTO;
import com.paybrook.eventregistration.dto.EventStatisticsDTO;
import com.paybrook.eventregistration.dto.in.EventDetailsInDTO;
import com.paybrook.eventregistration.entity.EventDetailsEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import static com.paybrook.eventregistration.constant.GlobalConstants.getZeroIfNUll;


@Mapper(componentModel = "spring")
public interface EventDetailsMapper
{
    EventDetailsEntity toEntity(EventDetailsInDTO eventDetailsInDTO);

    EventDetailsDTO toDTO(EventDetailsEntity eventDetailsEntity);

    List<EventDetailsDTO> toDTOs(List<EventDetailsEntity> eventDetailsEntities);

    EventDetailsEntity toUpdateEntity(@MappingTarget EventDetailsEntity eventDetailsEntity, EventDetailsInDTO eventDetailsInDTO);

    @Mapping(target = "totalRegistrations", source = "bookedSeats")
    EventStatisticsDTO toStatisticsDTO(EventDetailsEntity eventDetailsEntity);

    @AfterMapping
    default void calculateRemainingSeats(@MappingTarget EventStatisticsDTO eventStatisticsDTO, EventDetailsEntity eventDetailsEntity)
    {
        eventStatisticsDTO.setRemainingSeats(getZeroIfNUll(eventDetailsEntity.getMaxSeatsAllowed()) - getZeroIfNUll(eventDetailsEntity.getBookedSeats()));
    }
}
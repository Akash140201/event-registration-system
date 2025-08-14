package com.paybrook.eventregistration.mapper;

import com.paybrook.eventregistration.dto.AttendeeDTO;
import com.paybrook.eventregistration.dto.in.AttendeeInDTO;
import com.paybrook.eventregistration.entity.AttendeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendeeMapper {
    AttendeeEntity toEntity(AttendeeInDTO attendeeInDTO);

    AttendeeDTO toDTO(AttendeeEntity attendeeEntity);

    List<AttendeeDTO> toDTOs(List<AttendeeEntity> eventDetailsEntities);

    AttendeeEntity toUpdateEntity(@MappingTarget AttendeeEntity attendeeEntity, AttendeeInDTO attendeeInDTO);
}

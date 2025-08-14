package com.paybrook.eventregistration.service;

import com.paybrook.eventregistration.dto.AttendeeDTO;
import com.paybrook.eventregistration.dto.in.AttendeeInDTO;
import com.paybrook.eventregistration.entity.AttendeeEntity;
import com.paybrook.eventregistration.requestparams.AttendeeRequestParams;
import com.paybrook.eventregistration.requestparams.EventDetailsRequestParams;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AttendeeService {
    AttendeeDTO save(AttendeeInDTO attendeeInDTO);

    AttendeeDTO findById(Integer id);

    List<AttendeeDTO> findAll(AttendeeRequestParams attendeeRequestParams, Pageable pageable);

    AttendeeDTO update(Integer id, AttendeeInDTO attendeeInDTO);

    String delete(Integer id);

    AttendeeEntity getAttendeeEntity(int id);
}

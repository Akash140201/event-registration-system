package com.paybrook.eventregistration.service.impl;

import com.paybrook.eventregistration.dto.EventHasAttendeeDTO;
import com.paybrook.eventregistration.dto.in.EventHasAttendeeInDTO;
import com.paybrook.eventregistration.entity.AttendeeEntity;
import com.paybrook.eventregistration.entity.EventDetailsEntity;
import com.paybrook.eventregistration.entity.EventHasAttendeeEntity;
import com.paybrook.eventregistration.mapper.EventHasAttendeeMapper;
import com.paybrook.eventregistration.repository.EventHasAttendeeRepository;
import com.paybrook.eventregistration.service.AttendeeService;
import com.paybrook.eventregistration.service.EventDetailsService;
import com.paybrook.eventregistration.service.EventHasAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.paybrook.eventregistration.constant.GlobalConstants.getZeroIfNUll;

@Service
public class EventHasAttendeeServiceImpl implements EventHasAttendeeService {

    @Autowired
    private EventHasAttendeeRepository eventHasAttendeeRepository;

    @Autowired
    private EventHasAttendeeMapper eventHasAttendeeMapper;

    @Autowired
    private AttendeeService attendeeService;

    @Autowired
    private EventDetailsService eventDetailsService;


    @Override
    public EventHasAttendeeDTO save(EventHasAttendeeInDTO eventHasAttendeeInDTO) {
        int eventId = eventHasAttendeeInDTO.getEventId();
        int attendeeId = eventHasAttendeeInDTO.getAttendeeId();

        AttendeeEntity attendeeEntity = attendeeService.getAttendeeEntity(attendeeId);
        EventDetailsEntity eventDetailsEntity = eventDetailsService.getEventDetailsEntity(eventId);

        validateAttendeeOrEventIsNull(attendeeEntity, eventDetailsEntity);
        validateEventCapacity(eventDetailsEntity);

        EventHasAttendeeEntity eventHasAttendeeEntity = createEventHasAttendeeEntity(attendeeEntity, eventDetailsEntity);
        eventHasAttendeeRepository.save(eventHasAttendeeEntity);

        eventDetailsService.incrementBookedSeatOfEvent(eventDetailsEntity);

        return eventHasAttendeeMapper.toDTO(eventHasAttendeeEntity);
    }

    @Override
    public List<EventHasAttendeeDTO> findAll() {
        List<EventHasAttendeeEntity> eventHasAttendeeEntities = eventHasAttendeeRepository.findAll();
        return eventHasAttendeeMapper.toDTOs(eventHasAttendeeEntities);
    }

    private EventHasAttendeeEntity createEventHasAttendeeEntity(AttendeeEntity attendeeEntity, EventDetailsEntity eventDetailsEntity) {
        EventHasAttendeeEntity eventHasAttendeeEntity = new EventHasAttendeeEntity();
        eventHasAttendeeEntity.setAttendeeEntity(attendeeEntity);
        eventHasAttendeeEntity.setEventDetailsEntity(eventDetailsEntity);
        return eventHasAttendeeEntity;
    }

    private void validateAttendeeOrEventIsNull(AttendeeEntity attendeeEntity, EventDetailsEntity eventDetailsEntity) {
        if (attendeeEntity == null || eventDetailsEntity == null)
        {
            throw new RuntimeException("Either attendee or event does not exist");
        }
    }

    private void validateEventCapacity(EventDetailsEntity eventDetailsEntity) {
        if (eventDetailsEntity.getMaxSeatsAllowed() <= getZeroIfNUll(eventDetailsEntity.getBookedSeats()))
        {
            throw new RuntimeException("Seats are full");
        }
    }
}

package com.paybrook.eventregistration.service.impl;

import com.paybrook.eventregistration.dto.EventDetailsDTO;
import com.paybrook.eventregistration.dto.EventStatisticsDTO;
import com.paybrook.eventregistration.dto.in.EventDetailsInDTO;
import com.paybrook.eventregistration.entity.EventDetailsEntity;
import com.paybrook.eventregistration.mapper.EventDetailsMapper;
import com.paybrook.eventregistration.repository.EventDetailsRepository;
import com.paybrook.eventregistration.requestparams.EventDetailsRequestParams;
import com.paybrook.eventregistration.service.EventDetailsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.paybrook.eventregistration.constant.GlobalConstants.getZeroIfNUll;

@Service
public class EventDetailsServiceImpl implements EventDetailsService {

    @Autowired
    private EventDetailsMapper eventDetailsMapper;

    @Autowired
    private EventDetailsRepository eventDetailsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EventDetailsDTO save(EventDetailsInDTO eventDetailsInDTO) {
        try {
            validateEventDate(eventDetailsInDTO);

            EventDetailsEntity eventDetailsEntity = eventDetailsMapper.toEntity(eventDetailsInDTO);
            eventDetailsRepository.save(eventDetailsEntity);
            return eventDetailsMapper.toDTO(eventDetailsEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving event");
        }
    }

    @Override
    public EventDetailsDTO findById(Integer id) {
        EventDetailsEntity eventDetailsEntity = getEventDetailsEntity(id);
        return eventDetailsMapper.toDTO(eventDetailsEntity);
    }

    @Override
    public List<EventDetailsDTO> findAll(EventDetailsRequestParams eventDetailsRequestParams, Pageable pageable) {
        try {
            List<EventDetailsEntity> eventDetailsEntities = this.searchEvents(eventDetailsRequestParams.getTitle(), eventDetailsRequestParams.getVenue());
            return eventDetailsMapper.toDTOs(eventDetailsEntities);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching events");
        }
    }

    @Override
    public EventDetailsDTO update(Integer id, EventDetailsInDTO eventDetailsInDTO) {
        try {
            Optional<EventDetailsEntity> eventDetailsEntityOptional = eventDetailsRepository.findById(id);
            EventDetailsEntity eventDetailsEntity = null;
            if (eventDetailsEntityOptional.isPresent())
            {
                eventDetailsEntity = eventDetailsMapper.toUpdateEntity(eventDetailsEntityOptional.get(), eventDetailsInDTO);
                eventDetailsRepository.save(eventDetailsEntity);
            }
            return eventDetailsMapper.toDTO(eventDetailsEntity);
        } catch (Exception e)
        {
            throw new RuntimeException("Error while updating event");
        }
    }

    @Override
    public String delete(Integer id) {
        try {
            eventDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting event");
        }
        return "Deleted Successfully";
    }

    @Override
    public String cancelEvent(Integer id) {
        try
        {
            Optional<EventDetailsEntity> eventDetailsEntityOptional = eventDetailsRepository.findById(id);
            if (eventDetailsEntityOptional.isPresent())
            {
                EventDetailsEntity eventDetailsEntity = eventDetailsEntityOptional.get();
                eventDetailsEntity.setCancelled(true);
                eventDetailsRepository.save(eventDetailsEntity);
            }
            return "event cancelled successfully";
        } catch (Exception e)
        {
            throw new RuntimeException("Error while cancelling event");
        }
    }

    @Override
    public EventDetailsEntity getEventDetailsEntity(Integer id) {
        try {
            Optional<EventDetailsEntity> eventDetailsEntityOptional = eventDetailsRepository.findById(id);
            if (eventDetailsEntityOptional.isPresent())
            {
                return eventDetailsEntityOptional.get();
            } else {
                throw new RuntimeException("Event does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching event");
        }
    }

    @Override
    public void incrementBookedSeatOfEvent(EventDetailsEntity eventDetailsEntity) {
        eventDetailsEntity.setBookedSeats(getZeroIfNUll(eventDetailsEntity.getBookedSeats()) + 1);
        eventDetailsRepository.save(eventDetailsEntity);
    }

    @Override
    public EventStatisticsDTO getEventStatistics(Integer id) {
        EventDetailsEntity eventDetailsEntity = getEventDetailsEntity(id);
        return eventDetailsMapper.toStatisticsDTO(eventDetailsEntity);
    }


    public List<EventDetailsEntity> searchEvents(String title, String venue) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EventDetailsEntity> cq = cb.createQuery(EventDetailsEntity.class);
        Root<EventDetailsEntity> event = cq.from(EventDetailsEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            predicates.add(cb.like(cb.lower(event.get("title")), "%" + title.toLowerCase() + "%"));
        }
        if (venue != null && !venue.isEmpty()) {
            predicates.add(cb.like(cb.lower(event.get("venue")), "%" + venue.toLowerCase() + "%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }

    private void validateEventDate(EventDetailsInDTO eventDetailsInDTO) {
        if (eventDetailsInDTO.getEventDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Event date is in past");
        }
    }
}
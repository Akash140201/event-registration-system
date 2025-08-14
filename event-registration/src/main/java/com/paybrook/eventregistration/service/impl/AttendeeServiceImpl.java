package com.paybrook.eventregistration.service.impl;

import com.paybrook.eventregistration.dto.AttendeeDTO;
import com.paybrook.eventregistration.dto.in.AttendeeInDTO;
import com.paybrook.eventregistration.entity.AttendeeEntity;
import com.paybrook.eventregistration.mapper.AttendeeMapper;
import com.paybrook.eventregistration.repository.AttendeeRepository;
import com.paybrook.eventregistration.requestparams.AttendeeRequestParams;
import com.paybrook.eventregistration.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    @Autowired
    private AttendeeMapper attendeeMapper;

    @Autowired
    private AttendeeRepository attendeeRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public AttendeeDTO save(AttendeeInDTO attendeeInDTO) {
        try {
            AttendeeEntity attendeeEntity = attendeeMapper.toEntity(attendeeInDTO);
            attendeeRepository.save(attendeeEntity);
            return attendeeMapper.toDTO(attendeeEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error while saving attendee");
        }
    }

    @Override
    public AttendeeDTO findById(Integer id) {
        AttendeeEntity attendeeEntity = getAttendeeEntity(id);
        return attendeeMapper.toDTO(attendeeEntity);
    }

    @Override
    public List<AttendeeDTO> findAll(AttendeeRequestParams attendeeRequestParams, Pageable pageable) {
        try {

            List<AttendeeEntity> attendeeEntities = this.searchAttendee(attendeeRequestParams.getName(), attendeeRequestParams.getCity());
            return attendeeMapper.toDTOs(attendeeEntities);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching Attendee");
        }
    }

    @Override
    public AttendeeDTO update(Integer id, AttendeeInDTO attendeeInDTO) {
        try {
            Optional<AttendeeEntity> AttendeeEntityOptional = attendeeRepository.findById(id);
            AttendeeEntity attendeeEntity = null;
            if (AttendeeEntityOptional.isPresent())
            {
                attendeeEntity = attendeeMapper.toUpdateEntity(AttendeeEntityOptional.get(), attendeeInDTO);
                attendeeRepository.save(attendeeEntity);
            }
            return attendeeMapper.toDTO(attendeeEntity);
        } catch (Exception e)
        {
            throw new RuntimeException("Error while updating Attendee");
        }
    }

    @Override
    public String delete(Integer id) {
        try {
            attendeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting Attendee");
        }
        return "Deleted Successfully";
    }

    @Override
    public AttendeeEntity getAttendeeEntity(int id)
    {
        try {
            Optional<AttendeeEntity> attendeeEntityOptional = attendeeRepository.findById(id);
            if (attendeeEntityOptional.isPresent())
            {
                return attendeeEntityOptional.get();
            } else {
                throw new RuntimeException("Attendee does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching Attendee");
        }
    }

    public List<AttendeeEntity> searchAttendee(String name, String city) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<AttendeeEntity> cq = cb.createQuery(AttendeeEntity.class);
        Root<AttendeeEntity> attendee = cq.from(AttendeeEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(cb.lower(attendee.get("name")), "%" + name.toLowerCase() + "%"));
        }
        if (city != null && !city.isEmpty()) {
            predicates.add(cb.like(cb.lower(attendee.get("city")), "%" + city.toLowerCase() + "%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}

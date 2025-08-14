package com.paybrook.eventregistration.repository;

import com.paybrook.eventregistration.entity.EventDetailsEntity;
import com.paybrook.eventregistration.entity.EventHasAttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventHasAttendeeRepository extends JpaRepository<EventHasAttendeeEntity,Integer> {
}

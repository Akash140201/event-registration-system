package com.paybrook.eventregistration.repository;

import com.paybrook.eventregistration.entity.AttendeeEntity;
import com.paybrook.eventregistration.entity.EventDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<AttendeeEntity,Integer>  {
}

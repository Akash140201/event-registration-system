package com.paybrook.eventregistration.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.paybrook.eventregistration.entity.EventDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDetailsRepository extends JpaRepository<EventDetailsEntity ,Integer> {
}
package com.paybrook.eventregistration.entity;

import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "event_has_attendee")
@Data
public class EventHasAttendeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "ref_event_details")
    private EventDetailsEntity eventDetailsEntity;

    @ManyToOne
    @JoinColumn(name = "ref_attendee")
    private AttendeeEntity attendeeEntity;
}

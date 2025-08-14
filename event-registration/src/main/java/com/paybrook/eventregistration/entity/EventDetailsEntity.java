package com.paybrook.eventregistration.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Entity
@Table(name = "event_details")
public class EventDetailsEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "event_duration")
    private BigDecimal eventDuration;

    @Column(name = "venue")
    private String venue;

    @Column(name = "max_seats_allowed")
    private Integer maxSeatsAllowed;

    @Column(name = "booked_seats")
    @Nullable
    private Integer bookedSeats;

    @Column(name = "ticket_prize")
    private BigDecimal ticketPrice;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "is_cancelled")
    private boolean cancelled;
}

package com.paybrook.eventregistration.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NonNull;

@Data
public class EventDetailsDTO
{
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private BigDecimal eventDuration;
    private String venue;
    private Integer maxSeatsAllowed;
    private BigDecimal ticketPrice;
    private String organizer;
    private boolean cancelled;
}
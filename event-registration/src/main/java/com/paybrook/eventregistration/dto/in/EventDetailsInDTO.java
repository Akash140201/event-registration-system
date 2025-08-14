package com.paybrook.eventregistration.dto.in;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NonNull;

@Data
public class EventDetailsInDTO
{
    @NotNull
    private String title;
    private String description;
    private LocalDateTime eventDate;
    private BigDecimal eventDuration;
    @NotNull
    private String venue;
    private Integer maxSeatsAllowed;
    @NotNull
    private BigDecimal ticketPrice;
    private String organizer;
}
package com.paybrook.eventregistration.dto;

import lombok.Data;

@Data
public class EventStatisticsDTO {
    private String title;
    private Integer totalRegistrations;
    private Integer remainingSeats;
}

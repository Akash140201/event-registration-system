package com.paybrook.eventregistration.requestparams;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventDetailsRequestParams
{
    private String title;
    private LocalDateTime localDateTime;
    private String venue;
    private String organizer;
}
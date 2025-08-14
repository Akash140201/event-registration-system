package com.paybrook.eventregistration.dto;

import lombok.Data;

@Data
public class AttendeeDTO {
    private String name;
    private String city;
    private String zipcode;
    private int age;
    private String gender;
}

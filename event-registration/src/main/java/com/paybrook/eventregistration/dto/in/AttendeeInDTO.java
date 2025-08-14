package com.paybrook.eventregistration.dto.in;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AttendeeInDTO {
    private String name;
    private String city;
    private String zipcode;
    private int age;
    private String gender;
}

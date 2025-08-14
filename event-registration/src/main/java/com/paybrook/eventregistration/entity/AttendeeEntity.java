package com.paybrook.eventregistration.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "attendee")
public class AttendeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipcode;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;
}

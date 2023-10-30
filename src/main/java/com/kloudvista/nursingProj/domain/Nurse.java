package com.kloudvista.nursingProj.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;



@Data
@Entity
@Table(name = "nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstName",length = 50)
    @NotEmpty(message = "First name must be entered")
    private String firstName;

    @Column(name = "lastname",length = 50, columnDefinition = "lastname")
    private String lastName;
    private String address;

    @Column(name = "phone",length = 11,columnDefinition = "phone")
    private String phoneNumber;
    private String email;
    private boolean status;
}



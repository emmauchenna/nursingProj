package com.kloudvista.nursingProj.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NurseReq {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private Biodata biodata;

}

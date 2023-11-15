package com.kloudvista.nursingProj.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Biodata {
    private LocalDate dateOfBirth;
    private double height;
    private double weight;
}

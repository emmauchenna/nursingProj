package com.kloudvista.nursingProj.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Transactional
@Table(name = "bio_details")
public class BioDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bio_id")
    private long id;
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    private double height;
    private double weight;




    @OneToOne(mappedBy = "bioDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Nurse nurse;
}

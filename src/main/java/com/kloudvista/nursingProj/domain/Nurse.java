package com.kloudvista.nursingProj.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nurse")
@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private boolean status;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BioDetail bioDetail;








    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_id")
    private List<Reference> reference;

}




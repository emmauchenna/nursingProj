package com.kloudvista.nursingProj.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nurse_references")
@ToString
@Entity
@Builder
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @ManyToOne
    private Nurse nurse;
}

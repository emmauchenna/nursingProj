package com.kloudvista.nursingProj.domain;

import com.kloudvista.nursingProj.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@ToString
@Entity
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String street_2;
    private String city;
    private String stateProvince;
    private String country;
    private AddressType addressType;

}

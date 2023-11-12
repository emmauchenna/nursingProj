package com.kloudvista.nursingProj.dto;

import com.kloudvista.nursingProj.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private long id;
    private String street;
    private String street_2;
    private String city;
    private String stateProvince;
    private String country;
    private String addressType;

}

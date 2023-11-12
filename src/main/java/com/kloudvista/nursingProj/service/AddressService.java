package com.kloudvista.nursingProj.service;

import com.kloudvista.nursingProj.domain.Address;
import com.kloudvista.nursingProj.dto.AddressDto;

import java.util.List;

public interface AddressService {

    void saveAddress(AddressDto address);

   List<Address> getByStateProvince(String stateProvince);
   List<Address> getByCountry(String country);

   List<Address> getAllAddresses();


}

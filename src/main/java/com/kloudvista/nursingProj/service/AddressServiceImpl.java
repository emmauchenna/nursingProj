package com.kloudvista.nursingProj.service;

import com.kloudvista.nursingProj.domain.Address;
import com.kloudvista.nursingProj.dto.AddressDto;
import com.kloudvista.nursingProj.enums.AddressType;
import com.kloudvista.nursingProj.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveAddress(AddressDto addressDto) {

        Address address = new Address(0, addressDto.getStreet(), addressDto.getStreet_2(), addressDto.getCity(),
                addressDto.getStateProvince(), addressDto.getCountry(), AddressType.valueOf("HOME"));
        address.setStreet(addressDto.getStreet());

        addressRepository.save(address);

    }

    @Override
    public List<Address> getByStateProvince(String stateProvince) {
        return addressRepository.findByStateProvince3(stateProvince);
    }

    @Override
    public List<Address> getByCountry(String country) {
        return addressRepository.getAddressByCountry(country);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }


}

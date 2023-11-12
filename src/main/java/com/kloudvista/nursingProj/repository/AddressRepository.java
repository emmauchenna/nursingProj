package com.kloudvista.nursingProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kloudvista.nursingProj.domain.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    public List<Address> findByStateProvince(String stateProvince);

    @Query(value = "select * from  address where state_province = ?1", nativeQuery = true)
    public List<Address> findByStateProvince2(String stateProvince);


    //JPL
    @Query(value = "select a from Address a where a.stateProvince = ?1")
    public List<Address> findByStateProvince33(String stateProvince);

    @Query(value = "select a from Address a where a.stateProvince =:stateprovince")
    public List<Address> findByStateProvince3(@Param("stateprovince") String stateProvince);


    @Query("select a from Address a where a.country = :country")
    public List<Address> getAddressByCountry(@Param("country") String country);

    @Query(value = "select * from address", nativeQuery = true)
    public List<Address> getAllAddresses();

}

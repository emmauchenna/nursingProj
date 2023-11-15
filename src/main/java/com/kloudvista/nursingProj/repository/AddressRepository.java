package com.kloudvista.nursingProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kloudvista.nursingProj.domain.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    //Select --- Pattern --- model (entity), class
    public List<Address> findByStateProvince(String stateProvince);

    //nativeQuery
    @Query(value = "select * from  nurse_address where state_province = ?1", nativeQuery = true)
     List<Address> findByStateProvince2(String stateProvince);

    //JPL
    @Query(value = "select a from Address a where a.stateProvince = ?1")
    List<Address> findByStateProvince33(String stateProvince);

    //JPL
    @Query(value = "select a from Address a where a.id = ?1")
    Address getById(long id);

    @Query(value = "select a from Address a where a.stateProvince = ?1 and city = ?2")
    List<Address> findByStateProvince334(String stateProvince, String city);

    //JPL - named Parameter
    @Query(value = "select a from Address a where a.stateProvince =:stateprovince")
    List<Address> findByStateProvince3(@Param("stateprovince") String stateProvince);

    @Query("select a from Address a where a.country = :country")
    List<Address> getAddressByCountry(@Param("country") String country);

    @Query(value = "select * from address", nativeQuery = true)
    List<Address> getAllAddresses();

}

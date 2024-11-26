package com.alderaan.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a " +
            "JOIN FETCH a.street s " +
            "JOIN FETCH s.postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co ")
    Collection<Address> findAllAddressesWithDetails();

    @Query("SELECT a FROM Address a " +
            "JOIN FETCH a.street s " +
            "JOIN FETCH s.postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co " +
            "WHERE a.id = :id")
    Optional<Address> findAddressWithDetailsById(@Param("id") Integer id);
}
package com.alderaan.address.street;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street, Integer> {

    @Query("SELECT s FROM Street s " +
            "JOIN FETCH s.postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co ")
    Collection<Street> findAllStreetsWithDetails();

    @Query("SELECT s FROM Street s " +
            "JOIN FETCH s.postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co " +
            "WHERE s.id = :id")
    Optional<Street> findStreetWithDetailsById(@Param("id") Integer id);

    Optional<Street> findByName(String streetName);
}
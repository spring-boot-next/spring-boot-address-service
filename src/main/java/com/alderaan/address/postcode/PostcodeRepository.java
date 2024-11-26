package com.alderaan.address.postcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface PostcodeRepository extends JpaRepository<Postcode, Integer> {

    @Query("SELECT p FROM Postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co ")
    Collection<Postcode> findAllPostcodesWithDetails();

    @Query("SELECT p FROM Postcode p " +
            "JOIN FETCH p.city c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co " +
            "WHERE p.id = :id")
    Optional<Postcode> findPostcodeWithDetailsById(@Param("id") Integer id);

    Optional<Postcode> findByCode(String postcodeCode);
}
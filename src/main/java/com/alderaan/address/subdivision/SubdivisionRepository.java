package com.alderaan.address.subdivision;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

interface SubdivisionRepository extends JpaRepository<Subdivision, Integer> {

    @Query("SELECT sd FROM Subdivision sd " +
            "JOIN FETCH sd.country co ")
    Collection<Subdivision> findAllSubdivisionsWithDetails();

    @Query("SELECT sd FROM Subdivision sd " +
            "JOIN FETCH sd.country co " +
            "WHERE sd.id = :id")
    Optional<Subdivision> findSubdivisionWithDetailsById(@Param("id") Integer id);

    Optional<Subdivision> findByName(String subdivisionName);
}
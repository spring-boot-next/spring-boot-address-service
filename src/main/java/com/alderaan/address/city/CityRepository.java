package com.alderaan.address.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT c FROM City c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co ")
    Collection<City> findAllCitiesWithDetails();

    @Query("SELECT c FROM City c " +
            "JOIN FETCH c.subdivision sd " +
            "JOIN FETCH sd.country co " +
            "WHERE c.id = :id")
    Optional<City> findCityWithDetailsById(@Param("id") Integer id);

    Optional<City> findByName(String cityName);
}
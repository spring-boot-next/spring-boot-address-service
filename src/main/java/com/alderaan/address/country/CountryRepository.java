package com.alderaan.address.country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByName(String countryName);
}
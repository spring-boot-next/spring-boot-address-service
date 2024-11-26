package com.alderaan.address.city;

import com.alderaan.address.country.Country;
import com.alderaan.address.subdivision.Subdivision;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CityServiceImpl implements CityService {

    private final CityMapperService cityMapperService;
    private final CityRepository cityRepository;

    @Override
    public ResponseEntity<List<CityResponse>> findAllCities() {
        List<CityResponse> cityResponseList = cityRepository.findAllCitiesWithDetails().stream()
                .map(cityMapperService::mapEntityToDto)
                .toList();

        return ResponseEntity.ok(cityResponseList);
    }

    @Override
    public ResponseEntity<CityResponse> findCityById(Integer id) {
        City city = cityRepository.findCityWithDetailsById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));

        return ResponseEntity.ok(cityMapperService.mapEntityToDto(city));
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("City not found"));
    }

    @Override
    public City findOrCreateCityByName(String cityName, Subdivision subdivision, Country country) {
        return cityRepository.findByName(cityName)
                .orElseGet(() -> cityRepository.save(
                        City.builder()
                                .name(cityName)
                                .subdivision(subdivision)
                                .country(country)
                                .build())
                );
    }

    @Override
    @Transactional
    public ResponseEntity<CityResponse> saveCity(CityRequest request) {
        City city = cityRepository.findByName(request.getName())
                .orElseGet(() -> {
                    City newCity = cityMapperService.mapRequestToEntity(request);
                    return cityRepository.save(newCity);
                });

        return ResponseEntity.ok(cityMapperService.mapEntityToDto(city));
    }

    @Override
    @Transactional
    public ResponseEntity<CityResponse> updateCityById(Integer id, CityRequest request) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));

        City updatedCity = cityMapperService.mapRequestToEntity(request);
        updatedCity.setId(city.getId());
        cityRepository.save(updatedCity);

        return ResponseEntity.ok(cityMapperService.mapEntityToDto(updatedCity));
    }

    @Override
    public ResponseEntity<Void> deleteCityById(Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found"));

        cityRepository.delete(city);

        return ResponseEntity.noContent().build();
    }
}
package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationService {

    private final LocationRepository locationRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

//    public LocationService(LocationRepository locationRepository) {
//    }

    public Location createLocation(String city, String country, float latitude, float longitude, String region) {
        // todo valida data
        if (city == null || city.isBlank()){
            throw new RuntimeException("The name of city can not be empty");
        }
        if (country == null || country.isBlank()){
            throw new RuntimeException("The name of country can not be empty");
        }
        if (latitude < -90 || latitude > 90){
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        if (longitude < -180 || longitude > 180){
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        if (region.isBlank()){
           region=null;
        }
        Location location = new Location(null,city,country,latitude,longitude,region);

        return locationRepository.save(location);
    }
}

package com.sda.weather;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationController {

    private final LocationService locationService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String createNewLocation(String city, String country, float latitude, float longitude, String region) {

        try {
            Location newLocation = locationService.createLocation(city, country, latitude, longitude, region);
            return objectMapper.writeValueAsString(newLocation);
        } catch (Exception e) {
            return "{\"error message\": \"" + e.getMessage() + "\"}";
        }

    }
}

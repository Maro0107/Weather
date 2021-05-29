package com.sda.weather;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationServiceTest {
    LocationService locationService;

//    @Before
//    public void setUp(){
//        LocationRepository locationRepository = new LocationRepositoryMock();
//        locationService = new LocationService(locationRepository);
//    }

    @Test
    public void CreateNewLocation_CorrectValues() {
        Location result = locationService.createLocation("city", "country", 50.1f,60.2f,"region");

        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLatitude()).isEqualTo(50.1);
        assertThat(result.getLongitude()).isEqualTo(60.2);
        assertThat(result.getRegion()).isEqualTo("region");
    }


}

package com.sda.weather;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LocationServiceTest {
    LocationService locationService;

    @Before
    public void setUp(){
        LocationRepository locationRepository = new LocationRepositoryMock();
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void CreateNewLocation_CorrectValues() {
        Location result = locationService.createLocation("city", "country", 50.1f,60.2f,"region");

        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLatitude()).isEqualTo(50.1f);
        assertThat(result.getLongitude()).isEqualTo(60.2f);
        assertThat(result.getRegion()).isEqualTo("region");
    }

    @Test
    public void CreateNewLocation_RegionIsEmpty_CorrectValues() {
        Location result = locationService.createLocation("city", "country", 50.1f,60.2f,"");

        assertThat(result.getCity()).isEqualTo("city");
        assertThat(result.getCountry()).isEqualTo("country");
        assertThat(result.getLatitude()).isEqualTo(50.1f);
        assertThat(result.getLongitude()).isEqualTo(60.2f);
        assertThat(result.getRegion()).isNull();
    }
    @Test
    public void CreateNewLocation_CityIsEmpty_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("", "country", 50.1f,60.2f,""));

        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void CreateNewLocation_CityIsBlanc_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("   ", "country", 50.1f,60.2f,""));

        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }
    @Test
    public void CreateNewLocation_CountryIsEmpty_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("city", "", 50.1f,60.2f,""));

        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    public void CreateNewLocation_CountryIsBlanc_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("city", "   ", 50.1f,60.2f,""));

        assertThat(result).isExactlyInstanceOf(RuntimeException.class);
    }
    @Test
    public void CreateNewLocation_LatitudeToLow_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("city", "country", -91.1f,60.2f,""));

        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void CreateNewLocation_LongitudeToLow_CorrectValues() {
        Throwable result = catchThrowable(()-> locationService.createLocation("city", "country", -51.1f,-181.2f,""));

        assertThat(result).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}

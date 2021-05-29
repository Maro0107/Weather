package com.sda.weather;

public class WeatherApplication {
    public static void main(String[] args) {
        LocationController locationController = new LocationController();
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
    }
}

package com.sda.weather;

import java.util.ArrayList;
import java.util.List;

public class LocationRepositoryMock implements LocationRepository {

    private List<Location> entries = new ArrayList<>();

    @Override
    public Location save(Location entry) {
        entry.setId(1L);
        entries.add(entry);
        return entry;
    }
}

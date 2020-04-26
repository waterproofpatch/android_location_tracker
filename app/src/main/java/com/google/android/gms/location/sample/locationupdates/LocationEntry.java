package com.google.android.gms.location.sample.locationupdates;

import android.location.Location;

public class LocationEntry {
    private Location mLocation;
    private String mTime;

    public LocationEntry(Location location, String time) {
        this.mLocation = location;
        this.mTime = time;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public String getTime() {
        return this.mTime;
    }
}

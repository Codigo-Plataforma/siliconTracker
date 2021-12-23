package com.silicon.SiliconTracker.dtos;

import com.silicon.SiliconTracker.entities.Location;

public class LocationResponse {
    private String street;
    private String city;
    private int pinCode;
    private int x;
    private int y;
    private String lastUpdatedTime;

    public LocationResponse(Location location){
        this.street = location.getAddress().getStreet();
        this.city = location.getAddress().getCity();
        this.pinCode = location.getAddress().getPinCode();
        this.x = location.getCoordinate().getX();
        this.y = location.getCoordinate().getY();
        this.lastUpdatedTime = location.getLastUpdatedTime().toString();
    }
}
package com.silicon.SiliconTracker.dtos;

import com.silicon.SiliconTracker.entity.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponse {
    private String address;
    private String city;
    private int pinCode;
    private String latitude;
    private String longitude;
    private String lastUpdatedTime;

    public LocationResponse(Location location){
        this.address = location.getFullAddress();
        this.city = location.getCity();
        this.pinCode = location.getPinCode();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.lastUpdatedTime = location.getUpdatedTime().toString();
    }
}
package com.silicon.SiliconTracker.services;

import com.silicon.SiliconTracker.dao.LocationRepo;
import com.silicon.SiliconTracker.dtos.LocationRequest;
import com.silicon.SiliconTracker.dtos.LocationResponse;
import com.silicon.SiliconTracker.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LocationServices {

    @Autowired
    private LocationRepo locationRepo;

    public void updateLocation(LocationRequest locationRequest){
        Location location = new Location();
        location.setUid(UUID.randomUUID().toString());
        location.setFullAddress(locationRequest.getFullAddress());
        location.setCity(locationRequest.getCity());
        location.setPinCode(locationRequest.getPinCode());
        location.setLatitude(locationRequest.getLatitude());
        location.setLongitude(locationRequest.getLongitude());
        location.setUpdatedTime(LocalDateTime.now());
        locationRepo.save(location);
    }

    public List<LocationResponse> getLocation(int id){
        Pageable paging = PageRequest.of(id, 10);
        return locationRepo.findAll(paging).stream().map(LocationResponse::new).collect(Collectors.toList());
    }
}

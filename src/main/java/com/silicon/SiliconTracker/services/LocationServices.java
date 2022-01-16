package com.silicon.SiliconTracker.services;

import com.silicon.SiliconTracker.dao.LocationRepo;
import com.silicon.SiliconTracker.dtos.LocationRequest;
import com.silicon.SiliconTracker.dtos.LocationResponse;
import com.silicon.SiliconTracker.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationServices {

    @Autowired
    private LocationRepo locationRepo;

    public void updateLocation(Map<String, String> locationRequest){
        Location location = new Location();
        location.setUid(UUID.randomUUID().toString());
        location.setFullAddress(locationRequest.get("fullAddress"));
        location.setCity(locationRequest.get("city"));
        location.setPinCode(Integer.parseInt(locationRequest.get("pinCode")));
        location.setLatitude(locationRequest.get("latitude"));
        location.setLongitude(locationRequest.get("longitude"));
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy h:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        location.setUpdatedTime(dateFormat.format(new Date()).toString());
        location.setSystemTime(LocalDateTime.now());
        locationRepo.save(location);
    }

    public List<LocationResponse> getLocation(int id){
        Pageable paging = PageRequest.of(id, 10, Sort.by(Sort.Direction.DESC, "systemTime"));
        return locationRepo.findAll(paging).stream().map(LocationResponse::new).collect(Collectors.toList());
    }
}
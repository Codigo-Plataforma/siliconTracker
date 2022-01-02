package com.silicon.SiliconTracker.controllers;

import com.silicon.SiliconTracker.dtos.LocationRequest;
import com.silicon.SiliconTracker.dtos.LocationResponse;
import com.silicon.SiliconTracker.services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/location")
@RestController
public class LocationController {

    @Autowired
    private LocationServices locationServices;

    @PostMapping
    public Map<String, String> updateLocation(@RequestBody LocationRequest locationRequest){
        locationServices.updateLocation(locationRequest);
        Map<String, String> response = new HashMap<>();
        response.put("code", "200");
        response.put("message", "Location Updated");
        return response;
    }

    @GetMapping("{id}")
    public List<LocationResponse> getLocation(@PathVariable("id") Integer id){
        return locationServices.getLocation(id);
    }

}
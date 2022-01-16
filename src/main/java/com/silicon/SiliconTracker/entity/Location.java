package com.silicon.SiliconTracker.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "Location")
public class Location {
    @Id
    private String uid;
    private String fullAddress;
    private String city;
    private int pinCode;
    private String latitude;
    private String longitude;
    private String updatedTime;
    private LocalDateTime systemTime;
}

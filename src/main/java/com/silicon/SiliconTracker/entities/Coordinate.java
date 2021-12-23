package com.silicon.SiliconTracker.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Coordinate extends AbstractPersistable<Long> {
    private int latitude;
    private int longitude;
}
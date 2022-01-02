package com.silicon.SiliconTracker.dao;

import com.silicon.SiliconTracker.entity.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends MongoRepository<Location, String> {
}

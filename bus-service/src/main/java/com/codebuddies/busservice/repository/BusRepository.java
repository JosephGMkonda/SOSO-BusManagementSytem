package com.codebuddies.busservice.repository;

import com.codebuddies.busservice.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus,String> {
}

package com.codebuddies.busservice.repository;

import com.codebuddies.busservice.model.BusManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<BusManagement,String> {
}

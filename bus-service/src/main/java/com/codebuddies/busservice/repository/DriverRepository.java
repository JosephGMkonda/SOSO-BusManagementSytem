package com.codebuddies.busservice.repository;

import com.codebuddies.busservice.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver,String> {

}

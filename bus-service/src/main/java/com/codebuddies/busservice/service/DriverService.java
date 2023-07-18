package com.codebuddies.busservice.service;


import com.codebuddies.busservice.dto.DriverRequest;
import com.codebuddies.busservice.model.Driver;
import com.codebuddies.busservice.repository.BusRepository;
import com.codebuddies.busservice.repository.DriverRepository;
import org.springframework.stereotype.Service;
import com.codebuddies.busservice.model.BusManagement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final BusRepository busRepository;


    public DriverService(DriverRepository driverRepository, BusRepository busRepository) {
        this.driverRepository = driverRepository;
        this.busRepository = busRepository;
    }

    public Driver createDriver(DriverRequest driverRequest){
        List<BusManagement> bus = busRepository.findAllById(driverRequest.getBusIds());

        Driver driver = Driver.builder()
                .firstName(driverRequest.getFirstName())
                .lastName(driverRequest.getLastName())
                .licenseNumber(driverRequest.getLicenseNumber())
                .buses(bus)
                .build();
        return driverRepository.save(driver);

    }

    public Driver updateDriver(String driverId, DriverRequest driverRequest){

        Driver driver = getDriverById(driverId);
        List<BusManagement> buses = busRepository.findAllById(driverRequest.getBusIds());
        driver.setFirstName(driverRequest.getFirstName());
        driver.setLastName(driverRequest.getLastName());
        driver.setLicenseNumber(driverRequest.getLicenseNumber());
        driver.setBuses(buses);
        return driverRepository.save(driver);

    }

    public void deleteDriver(String driverId){
        Driver driver = getDriverById(driverId);
        driverRepository.delete(driver);
    }

    public Driver getDriverById(String driverId){
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        return optionalDriver.orElseThrow(() -> new NoSuchElementException("The driver not found"));
    }
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }


}

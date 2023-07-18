package com.codebuddies.busservice.controller;


import com.codebuddies.busservice.dto.BusRequest;
import com.codebuddies.busservice.dto.BusResponse;
import com.codebuddies.busservice.dto.DriverRequest;
import com.codebuddies.busservice.dto.DriverResponse;
import com.codebuddies.busservice.model.Driver;
import com.codebuddies.busservice.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@RequestBody DriverRequest driverRequest){
        driverService.createDriver(driverRequest);

    }

    @PutMapping("/{driverId}")
    public void updateDriver(@PathVariable String driverId, @RequestBody DriverRequest driverRequest){
        driverService.updateDriver(driverId, driverRequest);
    }

    @DeleteMapping("/{driverId}")
    public  void deleteDriver(@PathVariable String driverId){
        driverService.deleteDriver(driverId);
    }

    @GetMapping
    public List<Driver> getAllDriver(){
        return driverService.getAllDrivers();
    }


}

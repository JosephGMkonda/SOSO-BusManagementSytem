package com.codebuddies.busservice.controller;


import com.codebuddies.busservice.dto.BusRequest;
import com.codebuddies.busservice.dto.BusResponse;
import com.codebuddies.busservice.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBus(@RequestBody BusRequest busRequest){
        busService.createBus(busRequest);

    }

    @PutMapping("/{busId}")
    public void updateBus(@PathVariable String busId, @RequestBody BusRequest busRequest){
        busService.updateBus(busId, busRequest);
    }

    @DeleteMapping("/{busId}")
    public  void deleteBus(@PathVariable String busId){
        busService.deleteBus(busId);
    }

    @GetMapping
    public List<BusResponse> getAllBuses(){
        return busService.getAllBuses();
    }



}

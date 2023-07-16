package com.codebuddies.busservice.service;
import com.codebuddies.busservice.dto.BusRequest;
import com.codebuddies.busservice.dto.BusResponse;
import com.codebuddies.busservice.model.Bus;
import com.codebuddies.busservice.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BusService {
    private final BusRepository busRepository;



    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    //adding bus repository into database
    public void createBus(BusRequest busRequest){
        Bus bus = Bus.builder()
                .name(busRequest.getName())
                .numberPlate(busRequest.getNumberPlate())
                .route(busRequest.getRoute())
                .price(busRequest.getPrice())
                .build();
        busRepository.save(bus);
    }

    //update the Bus
    public void updateBus(String busId, BusRequest busRequest){
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new NoSuchElementException("Bus not find"));

        bus.setName(busRequest.getName());
        bus.setNumberPlate(busRequest.getName());
        bus.setRoute(busRequest.getRoute());
        bus.setPrice(busRequest.getPrice());

        busRepository.save(bus);
    }

    // delete bus
    public void deleteBus(String busId){
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new NoSuchElementException("Bus is not found"));
        busRepository.delete(bus);
    }

    // getting all the Buses
    public List<BusResponse> getAllBuses(){
        List<Bus> buses = busRepository.findAll();
        List<BusResponse>  busResponses = new ArrayList<>();


        for (Bus bus : buses){
            BusResponse busResponse = new BusResponse();
            busResponse.setId(bus.getId());
            busResponse.setName(bus.getName());
            busResponse.setNumberPlate(bus.getNumberPlate());
            busResponse.setRoute(bus.getRoute());
            busResponse.setRoute(bus.getRoute());

            busResponse.add(busResponse);
        }

        return busResponses;
    }


}

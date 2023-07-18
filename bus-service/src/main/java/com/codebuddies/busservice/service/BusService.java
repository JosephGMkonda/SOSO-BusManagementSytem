package com.codebuddies.busservice.service;
import com.codebuddies.busservice.dto.BusRequest;
import com.codebuddies.busservice.dto.BusResponse;
import com.codebuddies.busservice.model.BusManagement;
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
        BusManagement busManagement = BusManagement.builder()
                .name(busRequest.getName())
                .numberPlate(busRequest.getNumberPlate())
                .route(busRequest.getRoute())
                .price(busRequest.getPrice())
                .build();
        busRepository.save(busManagement);
    }

    //update the BusManagement
    public void updateBus(String busId, BusRequest busRequest){
        BusManagement busManagement = busRepository.findById(busId)
                .orElseThrow(() -> new NoSuchElementException("BusManagement not find"));

        busManagement.setName(busRequest.getName());
        busManagement.setNumberPlate(busRequest.getName());
        busManagement.setRoute(busRequest.getRoute());
        busManagement.setPrice(busRequest.getPrice());

        busRepository.save(busManagement);
    }

    // delete bus
    public void deleteBus(String busId){
        BusManagement busManagement = busRepository.findById(busId)
                .orElseThrow(() -> new NoSuchElementException("BusManagement is not found"));
        busRepository.delete(busManagement);
    }

    // getting all the Buses
    public List<BusResponse> getAllBuses(){
        List<BusManagement> busManagements = busRepository.findAll();
        List<BusResponse>  busResponses = new ArrayList<>();


        for (BusManagement busManagement : busManagements){
            BusResponse busResponse = new BusResponse();
            busResponse.setId(busManagement.getId());
            busResponse.setName(busManagement.getName());
            busResponse.setNumberPlate(busManagement.getNumberPlate());
            busResponse.setRoute(busManagement.getRoute());
            busResponse.setPrice(busManagement.getPrice());

            busResponses.add(busResponse);
        }

        return busResponses;
    }


}
